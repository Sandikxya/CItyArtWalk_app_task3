package com.example.cityartwalkapp

import android.R.attr.tag
import android.os.Bundle
import android.content.pm.PackageManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MainActivity : AppCompatActivity() {

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) fetchLocation() else {
            showPermissionDeniedMessage()
        }

    }


    @Suppress("SENSELESS_COMPARISON")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationButton: Button = findViewById(R.id.getGpsButton)
        locationButton.setOnClickListener(MainActivity.requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION))

        fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requiredContext())

        }


       fun fetchLocation() {
           if (ActivityCompat.checkSelfPermission(requireContext(),android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
               || ActivityCompat.checkSelfPermission(requireContext(),android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

           ){
               Log.d(tag: "GPS", msg: "Have permissions. Try to get a location")
               if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(requireContext()) == ConnectionResult.SUCCESS) {
                   return
               }
               // Get Location
        }


       fun fetchLocation() {
           // Check if the permission has already been granted.
           if (ActivityCompat.checkSelfPermission((requireContext(),android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

               fusedLocationClient.lastLocation
                   .addOnSuccessListener(this, OnSuccessListener { location ->
                       if(location != null) {
                           val latitude = location.latitude
                           val longitude = location.longitude
                           showLocation(latitude, longitude)
                       } else{
                           //location is null.
                           Toast.makeText(this, "Location is not available", Toast.LENGTH_SHORT).show()
                       }
                   })
           } else{
               // Permission is not granted.
               Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show()
           }
       }    
       
           
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

override fun onMapReady(googleMap: GoogleMap) {
    mMap = googleMap
    updateUI {
        LatLng myPoint =
    }
}

    fun showLocation(latitude: Double, longitude: Double) {

        Toast.makeText(this, "Location: Latitude:$latitude, Longitude: $longitude ", Toast.LENGTH_LONG).show()
    }

    fun requiredContext() {
        TODO("Not yet implemented")
    }

    fun fetchLocation() {}
    fun showPermissionDeniedMessage(): Unit {}
}

    fun updateUI(function: () -> myPoint) {
        // Add a marker in the given location and move the camera.
        mMap.clear()

        private void updateUI {
            LatLng myPoint = new LatLng(latitude, longitude)
        mMap.addMarker(MarkerOptions().position(mypoint).title("art work"))
           }

        val zoomLevel: Float = 10f
        val update: CameraUpdate = CameraUpdateFactory.newLatLngZoom(mypoint, zoomLevel)

        mMap.animateCamera(update)
    }
}



