package com.udacity.project4.locationreminders.geofence

import com.google.android.gms.location.Geofence

object GeofenceUtils {
    const val GEOFENCE_RADIUS_IN_METERS = 100f
    const val EXTRA_GEOFENCE_INDEX = "GEOFENCE_INDEX"
    const val NEVER_EXPIRES = Geofence.NEVER_EXPIRE
}