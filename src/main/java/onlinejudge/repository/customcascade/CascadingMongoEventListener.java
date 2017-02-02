package onlinejudge.repository.customcascade;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class CascadingMongoEventListener<E> extends AbstractMongoEventListener<E> {
	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public void onBeforeConvert(final E source) {
		ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {

			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				IDCheckCallback callback = new IDCheckCallback();
				ReflectionUtils.makeAccessible(field);
				if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
					final Object fieldValue = field.get(source);

					if (fieldValue != null && Collection.class.isAssignableFrom(field.getType())) {
						Collection list = (Collection) fieldValue;
						/*  
						  for (Object obj : list) {
							if (obj != null) {
								ReflectionUtils.doWithFields(obj.getClass(), callback);
								if (!callback.isIdFound()) {
									throw new MappingException("Cannot perform cascade save on Collection<"
											+ obj.getClass().getName() + "> object without id set");
								} else {
									mongoOperations.save(obj);
								}
							}
						}*/
						
						Iterator ito = list.iterator();
						Object obj;
						while(ito.hasNext()){
							obj = ito.next();
							if(obj!=null){
								ReflectionUtils.doWithFields(obj.getClass(), callback);
								if (!callback.isIdFound()) {
									throw new MappingException("Cannot perform cascade save on Collection<"
											+ obj.getClass().getName() + "> object without id set");
								} else {
									mongoOperations.save(obj);
								}
							}else{
								ito.remove();
							}
						}
					} else if (fieldValue != null && Map.class.isAssignableFrom(field.getType())) {
						Map map = (Map) fieldValue;

						/*Collection list = (Collection) map.values();
						for (Object obj : list) {
							if (obj != null) {
								ReflectionUtils.doWithFields(obj.getClass(), callback);
								if (!callback.isIdFound()) {
									throw new MappingException("Cannot perform cascade save on Map<"
											+ obj.getClass().getName() + "> object without id set");
								} else {
									mongoOperations.save(obj);
								}
							}
						}*/
						
						Set keys = map.entrySet();
						Object obj;
						for (Object key : keys) {
							obj = map.get(key);
							if(obj != null){
								ReflectionUtils.doWithFields(obj.getClass(), callback);
								if (!callback.isIdFound()) {
									throw new MappingException("Cannot perform cascade save on Map<"
											+ obj.getClass().getName() + "> object without id set");
								} else {
									mongoOperations.save(obj);
								}
							}else{
								map.remove(key);
							}
						}

					} else if (fieldValue != null) {

						ReflectionUtils.doWithFields(fieldValue.getClass(), callback);

						if (!callback.isIdFound()) {
							throw new MappingException("Cannot perform cascade save on child object without id set");
						} else {
							mongoOperations.save(fieldValue);
						}
					}
				}
			}
		});
	}

	private static class IDCheckCallback implements ReflectionUtils.FieldCallback {
		private boolean idFound;

		public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
			ReflectionUtils.makeAccessible(field);

			if (field.isAnnotationPresent(Id.class)) {
				idFound = true;
			}
		}

		public boolean isIdFound() {
			return idFound;
		}
	}
}
