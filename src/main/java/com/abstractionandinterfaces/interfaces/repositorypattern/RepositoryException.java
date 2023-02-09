package com.abstractionandinterfaces.interfaces.repositorypattern;

public class RepositoryException extends RuntimeException
{
  public RepositoryException(final String message, final Throwable cause)
  {
    super(message, cause);
  }
}
