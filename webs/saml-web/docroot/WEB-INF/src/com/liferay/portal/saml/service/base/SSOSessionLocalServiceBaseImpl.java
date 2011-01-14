/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.saml.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.saml.model.SSOSession;
import com.liferay.portal.saml.service.SPSessionLocalService;
import com.liferay.portal.saml.service.SSOSessionLocalService;
import com.liferay.portal.saml.service.persistence.SPSessionPersistence;
import com.liferay.portal.saml.service.persistence.SSOSessionPersistence;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the s s o session local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portal.saml.service.impl.SSOSessionLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.saml.service.impl.SSOSessionLocalServiceImpl
 * @see com.liferay.portal.saml.service.SSOSessionLocalServiceUtil
 * @generated
 */
public abstract class SSOSessionLocalServiceBaseImpl
	implements SSOSessionLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portal.saml.service.SSOSessionLocalServiceUtil} to access the s s o session local service.
	 */

	/**
	 * Adds the s s o session to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ssoSession the s s o session to add
	 * @return the s s o session that was added
	 * @throws SystemException if a system exception occurred
	 */
	public SSOSession addSSOSession(SSOSession ssoSession)
		throws SystemException {
		ssoSession.setNew(true);

		return ssoSessionPersistence.update(ssoSession, false);
	}

	/**
	 * Creates a new s s o session with the primary key. Does not add the s s o session to the database.
	 *
	 * @param ssoSessionId the primary key for the new s s o session
	 * @return the new s s o session
	 */
	public SSOSession createSSOSession(long ssoSessionId) {
		return ssoSessionPersistence.create(ssoSessionId);
	}

	/**
	 * Deletes the s s o session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ssoSessionId the primary key of the s s o session to delete
	 * @throws PortalException if a s s o session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteSSOSession(long ssoSessionId)
		throws PortalException, SystemException {
		ssoSessionPersistence.remove(ssoSessionId);
	}

	/**
	 * Deletes the s s o session from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ssoSession the s s o session to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteSSOSession(SSOSession ssoSession)
		throws SystemException {
		ssoSessionPersistence.remove(ssoSession);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return ssoSessionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return ssoSessionPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return ssoSessionPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return ssoSessionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the s s o session with the primary key.
	 *
	 * @param ssoSessionId the primary key of the s s o session to get
	 * @return the s s o session
	 * @throws PortalException if a s s o session with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SSOSession getSSOSession(long ssoSessionId)
		throws PortalException, SystemException {
		return ssoSessionPersistence.findByPrimaryKey(ssoSessionId);
	}

	/**
	 * Gets a range of all the s s o sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of s s o sessions to return
	 * @param end the upper bound of the range of s s o sessions to return (not inclusive)
	 * @return the range of s s o sessions
	 * @throws SystemException if a system exception occurred
	 */
	public List<SSOSession> getSSOSessions(int start, int end)
		throws SystemException {
		return ssoSessionPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of s s o sessions.
	 *
	 * @return the number of s s o sessions
	 * @throws SystemException if a system exception occurred
	 */
	public int getSSOSessionsCount() throws SystemException {
		return ssoSessionPersistence.countAll();
	}

	/**
	 * Updates the s s o session in the database. Also notifies the appropriate model listeners.
	 *
	 * @param ssoSession the s s o session to update
	 * @return the s s o session that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public SSOSession updateSSOSession(SSOSession ssoSession)
		throws SystemException {
		ssoSession.setNew(false);

		return ssoSessionPersistence.update(ssoSession, true);
	}

	/**
	 * Updates the s s o session in the database. Also notifies the appropriate model listeners.
	 *
	 * @param ssoSession the s s o session to update
	 * @param merge whether to merge the s s o session with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the s s o session that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public SSOSession updateSSOSession(SSOSession ssoSession, boolean merge)
		throws SystemException {
		ssoSession.setNew(false);

		return ssoSessionPersistence.update(ssoSession, merge);
	}

	/**
	 * Gets the s p session local service.
	 *
	 * @return the s p session local service
	 */
	public SPSessionLocalService getSPSessionLocalService() {
		return spSessionLocalService;
	}

	/**
	 * Sets the s p session local service.
	 *
	 * @param spSessionLocalService the s p session local service
	 */
	public void setSPSessionLocalService(
		SPSessionLocalService spSessionLocalService) {
		this.spSessionLocalService = spSessionLocalService;
	}

	/**
	 * Gets the s p session persistence.
	 *
	 * @return the s p session persistence
	 */
	public SPSessionPersistence getSPSessionPersistence() {
		return spSessionPersistence;
	}

	/**
	 * Sets the s p session persistence.
	 *
	 * @param spSessionPersistence the s p session persistence
	 */
	public void setSPSessionPersistence(
		SPSessionPersistence spSessionPersistence) {
		this.spSessionPersistence = spSessionPersistence;
	}

	/**
	 * Gets the s s o session local service.
	 *
	 * @return the s s o session local service
	 */
	public SSOSessionLocalService getSSOSessionLocalService() {
		return ssoSessionLocalService;
	}

	/**
	 * Sets the s s o session local service.
	 *
	 * @param ssoSessionLocalService the s s o session local service
	 */
	public void setSSOSessionLocalService(
		SSOSessionLocalService ssoSessionLocalService) {
		this.ssoSessionLocalService = ssoSessionLocalService;
	}

	/**
	 * Gets the s s o session persistence.
	 *
	 * @return the s s o session persistence
	 */
	public SSOSessionPersistence getSSOSessionPersistence() {
		return ssoSessionPersistence;
	}

	/**
	 * Sets the s s o session persistence.
	 *
	 * @param ssoSessionPersistence the s s o session persistence
	 */
	public void setSSOSessionPersistence(
		SSOSessionPersistence ssoSessionPersistence) {
		this.ssoSessionPersistence = ssoSessionPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = ssoSessionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = SPSessionLocalService.class)
	protected SPSessionLocalService spSessionLocalService;
	@BeanReference(type = SPSessionPersistence.class)
	protected SPSessionPersistence spSessionPersistence;
	@BeanReference(type = SSOSessionLocalService.class)
	protected SSOSessionLocalService ssoSessionLocalService;
	@BeanReference(type = SSOSessionPersistence.class)
	protected SSOSessionPersistence ssoSessionPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}