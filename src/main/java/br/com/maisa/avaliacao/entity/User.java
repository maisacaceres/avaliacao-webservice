package br.com.maisa.avaliacao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String name;
	private long inbox;
	private long size;
	
	protected User() {}
	
	public User(String name, long inbox, long size)
	{
		this.name = name;
		this.inbox = inbox;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	
	public long getInbox() {
		return inbox;
	}
	
	public long getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", inbox=" + inbox + ", inbox_size=" + size + "]";
	}
}
