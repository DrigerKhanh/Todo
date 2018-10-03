package entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
@Id
@Column(name="username", nullable=false, unique=true)
private String username;
@Column(name="password")
private String password;
@ManyToMany
@JoinTable(
		name="user_role",
		joinColumns=@JoinColumn(name="username"),
		inverseJoinColumns=@JoinColumn(name="role")
		)
private Set<Role> roles;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Set<Role> getRoles() {
	return roles;
}
public void setRoles(Set<Role> roles) {
	this.roles = roles;
}


	

}
