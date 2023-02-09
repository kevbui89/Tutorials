package com.abstractionandinterfaces.interfaces.repositorypattern.database;

import java.sql.ResultSet;
import java.util.Iterator;

import com.abstractionandinterfaces.interfaces.repositorypattern.ClientEngagement;

class DatabaseIterable implements Iterable<ClientEngagement>
{
  private ResultSet resultSet;

  public DatabaseIterable(final ResultSet resultSet)
  {
    this.resultSet = resultSet;
  }

  @Override
  public Iterator<ClientEngagement> iterator()
  {
    return new DatabaseIterator(resultSet);
  }
}
