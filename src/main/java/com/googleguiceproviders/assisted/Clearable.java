package com.googleguiceproviders.assisted;

import com.googleguiceproviders.assisted.exceptions.ClearanceException;

public interface Clearable {

  public Clearance probeClearance() throws ClearanceException;
}
