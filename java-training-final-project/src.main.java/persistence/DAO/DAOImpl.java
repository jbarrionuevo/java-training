package persistence.DAO;

import org.hibernate.Session;

import domain.BaseEntity;

public class DAOImpl<E extends BaseEntity> extends AbstractDAO<BaseEntity> {

	public DAOImpl(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

}