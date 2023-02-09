package com.abstractionandinterfaces.interfaces.repositorypattern;

import lombok.Getter;
import lombok.Setter;

public class ClientEngagement
{
  @Getter
  private final String client;
  @Getter
  private final int hoursWorked;
  @Getter
  @Setter
  private int id;

  public ClientEngagement(final String client, final int hoursWorked)
  {
    this.client = client;
    this.hoursWorked = hoursWorked;
  }

  @Override
  public String toString()
  {
    return "ClientEngagement{" +
        "id=" + id +
        ", client='" + client + '\'' +
        ", hoursWorked=" + hoursWorked +
        '}';
  }
}
