package com.googleguiceproviders.assisted;

import com.googleguiceproviders.assisted.ClearanceProber.ClearaceProberFactory;
import com.googleguiceproviders.assisted.exceptions.ClearanceException;
import com.google.inject.Inject;

public class ClearanceService {

  private final ClearaceProberFactory clearaceProberFactory;

  @Inject
  public ClearanceService(ClearaceProberFactory clearaceProberFactory) {
    this.clearaceProberFactory = clearaceProberFactory;
  }

  public Clearance requestClearance(String proposedClearance, FlightPlan flightPlan) throws
      ClearanceException
  {
    Clearable clearaceProber = clearaceProberFactory.create(proposedClearance, flightPlan.getFlightID());
    return clearaceProber.probeClearance();
  }

  //etc...

}
