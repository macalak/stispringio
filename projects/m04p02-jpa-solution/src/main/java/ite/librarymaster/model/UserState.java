package ite.librarymaster.model;

/**
 * This enumeration represents the Library user state.
 * User can be in one of the following states:
 *  Active   - Active user can borrow books or medias from the Library 
 *  Inactive - Inactive user (no membership dues paid)
 *  Blocked  - Blocked user (no penalty paid)
 *  
 * @author macalak@itexperts.sk
 *
 */
public enum UserState {
	Active,
	Inactive,
	Blocked
}
