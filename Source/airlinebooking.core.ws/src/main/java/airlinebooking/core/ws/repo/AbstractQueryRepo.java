package airlinebooking.core.ws.repo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.type.Type;

public class AbstractQueryRepo {
	protected void addParameters(Query query, List<Object> params) {
		if (params != null) {
			int i = 0;
			for (Object p : params) {
				query.setParameter(i, p);
				i++;
			}
		}
	}

	protected void addScalar(SQLQuery query, String[] fieldNames,
			Type[] fieldTypes) {
		for (int i = 0; i < fieldNames.length; i++) {
			query.addScalar(fieldNames[i], fieldTypes[i]);
		}
	}

	// private void addCacheConfig(Query query, CacheConfig cacheConfig) {
	// query.setCacheable(cacheConfig.isCache());
	// if (cacheConfig.isCache() && cacheConfig.getRegionKey() != null) {
	// query.setCacheRegion(cacheConfig.getRegionKey());
	// }
	// }

	protected void addSynchronizedClass(SQLQuery query,
			List<Class<?>> synchronizedClass) {
		if (synchronizedClass != null) {
			for (Class<?> clazz : synchronizedClass) {
				query.addSynchronizedEntityClass(clazz);
			}
		}
	}
}
