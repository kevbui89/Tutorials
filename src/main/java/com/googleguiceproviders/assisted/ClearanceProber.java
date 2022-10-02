package com.googleguiceproviders.assisted;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.googleguiceproviders.assisted.exceptions.ClearanceException;
import com.googleguiceproviders.assisted.exceptions.ProbeException;

public class ClearanceProber implements Clearable {

  private final String clearance;
  private final Long flightID;
  private final Prober prober;

  @Inject
  ClearanceProber (@Assisted String clearance,
      @Assisted Long flightID,
      Prober prober
  )
  {
    this.clearance = clearance;
    this.flightID = flightID;
    this.prober = prober;
  }

  public interface ClearaceProberFactory{
    Clearable create(String clearance, Long flightID);
  }

  @Override
  public Clearance probeClearance() throws ClearanceException
  {
    ProbeResult probeResult = null;
    try {
      probeResult = probe();
    } catch (ProbeException ex) {
      throw new ClearanceException("Unabled to issue Clearance for flight ID: " + flightID);
    }

    return new Clearance(clearance, probeResult);
  }

  private ProbeResult probe() throws ProbeException {
    return prober.probe(flightID, clearance);
  }
}