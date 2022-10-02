package com.googleguiceproviders.assisted;

import com.googleguiceproviders.assisted.exceptions.ProbeException;

public class Prober {

  public ProbeResult probe(Long flightID, String clearance) throws ProbeException
  {
    if (flightID == 0) {
      throw new ProbeException("Conflict detected");
    }
    return new ProbeResult();
  }

}