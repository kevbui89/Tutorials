package com.abstractionandinterfaces.interfaces.repositorypattern;

public class Runner
{
  public static void main(String[] args)
  {
    ClientEngagementRepository repository = null;

    final Iterable<ClientEngagement> engagements = repository.find(new Query()
        .atLeastHoursWorked(5)
        .client("Pluralsight"));

    for (ClientEngagement engagement : engagements)
    {

    }
  }
}
