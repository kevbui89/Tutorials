package com.abstractionandinterfaces.interfaces.repositorypattern;

public interface ClientEngagementRepository extends AutoCloseable
{
  int NO_ID = 0;

  void add(ClientEngagement clientEngagement) throws RepositoryException;

  void remove(ClientEngagement clientEngagement) throws RepositoryException;

  Iterable<ClientEngagement> find(Query query) throws RepositoryException;
}
