package airlinebooking.common.enumtype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.TypeResolver;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

public class GenericEnumUserType implements UserType, ParameterizedType,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6001384528624564248L;
	private static final String defaultIdentifierMethodName = "name";
	private static final String defaultValueOfMethodName = "valueOf";

	@SuppressWarnings("rawtypes")
	private Class<? extends Enum> enumClass;

	@SuppressWarnings("rawtypes")
	private AbstractSingleColumnStandardBasicType type;

	private String identifierMethodName;
	private Class<?> identifierType;

	private String valueOfMethodName;

	private int[] sqlTypes;

	@SuppressWarnings("rawtypes")
	@Override
	public void setParameterValues(Properties parameters) {
		String enumClassName = parameters.getProperty("enumClass");
		try {
			enumClass = Class.forName(enumClassName).asSubclass(Enum.class);
		} catch (ClassNotFoundException exception) {
			throw new HibernateException("Enum class not found", exception);
		}

		identifierMethodName = parameters.getProperty("identifierMethod",
				defaultIdentifierMethodName);

		try {
			identifierType = enumClass.getMethod(identifierMethodName,
					new Class[0]).getReturnType();
		} catch (Exception exception) {
			throw new HibernateException("Failed to optain identifier method",
					exception);
		}

		TypeResolver tr = new TypeResolver();
		type = (AbstractSingleColumnStandardBasicType) tr.basic(identifierType
				.getName());
		if (type == null) {
			throw new HibernateException("Unsupported identifier type "
					+ identifierType.getName());
		}
		sqlTypes = new int[] { type.sqlType() };

		valueOfMethodName = parameters.getProperty("valueOfMethod",
				defaultValueOfMethodName);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return enumClass;
	}

	@Override
	public Object nullSafeGet(ResultSet resultSet, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		Object identifier = type.get(resultSet, names[0], session);
		try {
			return enumClass.getMethod(valueOfMethodName,
					new Class[] { identifierType }).invoke(enumClass,
					new Object[] { identifier });
		} catch (Exception exception) {
			throw new HibernateException(
					"Exception while invoking valueOfMethod of enumeration class: ",
					exception);
		}
	}

	@Override
	public void nullSafeSet(PreparedStatement preparedStatement, Object value,
			int index, SessionImplementor session) throws HibernateException,
			SQLException {
		try {
			Object identifier = value != null ? enumClass.getMethod(
					identifierMethodName, new Class[0]).invoke(value,
					new Object[0]) : null;
			preparedStatement.setObject(index, identifier);
		} catch (Exception exception) {
			throw new HibernateException(
					"Exception while invoking identifierMethod of enumeration class: ",
					exception);
		}
	}

	@Override
	public int[] sqlTypes() {
		return sqlTypes;
	}

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return x == y;
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	public boolean isMutable() {
		return false;
	}

	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	public static void main(String[] args) {
	}
}