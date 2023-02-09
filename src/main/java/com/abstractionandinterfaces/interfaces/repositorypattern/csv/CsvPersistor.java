package com.abstractionandinterfaces.interfaces.repositorypattern.csv;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// import com.opencsv.CSVReader;

import com.abstractionandinterfaces.interfaces.repositorypattern.ClientEngagement;
import com.abstractionandinterfaces.interfaces.repositorypattern.RepositoryException;

class CsvPersistor
{
  private static final int CLIENT_COL = 0;
  private static final int HOURS_WORKED_COL = 1;

  private final String path;

  CsvPersistor(final String path)
  {
    this.path = path;
  }

  List<ClientEngagement> load()
  {
    // The opencvs:opencvs jar does not load
    //    try (CSVReader reader = new CSVReader(new FileReader(path)))
    //    {
    //      final List<ClientEngagement> engagements = new ArrayList<>();
    //      final Iterator<String[]> iterator = reader.iterator();
    //      while (iterator.hasNext())
    //      {
    //        final String[] row = iterator.next();
    //        final String client = row[CLIENT_COL];
    //        final int hoursWorked = Integer.parseInt(row[HOURS_WORKED_COL]);
    //        engagements.add(new ClientEngagement(client, hoursWorked));
    //      }
    //      return engagements;
    //    }
    //    catch (IOException e)
    //    {
    //      throw new RepositoryException("unable to load contents of " + path, e);
    //    }
    return null;
  }

  void save(final List<ClientEngagement> engagements)
  {
    //    try (CSVWriter csvWriter = new CSVWriter(new FileWriter(path)))
    //    {
    //      engagements.forEach(engagement ->
    //      {
    //        final String[] row = {
    //            engagement.getClient(),
    //            String.valueOf(engagement.getHoursWorked())
    //        };
    //        csvWriter.writeNext(row);
    //      });
    //    }
    //    catch (IOException e)
    //    {
    //      throw new RepositoryException("Unable to save contents of " + path, e);
    //    }
  }
}
