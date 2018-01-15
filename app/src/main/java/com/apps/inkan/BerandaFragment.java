package com.apps.inkan;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.inkan.rest.OpenWeatherMapAPI;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;


/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends android.support.v4.app.Fragment implements LocationListener{

    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;
    Typeface weatherFont;
    //    Button getLocationBtn;
    TextView locationText;
    String lat, lon = "";
    LocationManager locationManager;

    OpenWeatherMapAPI.placeIdTask asyncTask = new OpenWeatherMapAPI.placeIdTask(new OpenWeatherMapAPI.AsyncResponse() {
        public void processFinish(String weather_city, String weather_description, String weather_temperature, String weather_humidity, String weather_pressure, String weather_updatedOn, String weather_iconText, String sun_rise) {

            cityField.setText(weather_city);
            updatedField.setText(weather_updatedOn);
            detailsField.setText(weather_description);
            currentTemperatureField.setText(weather_temperature);
            humidity_field.setText("Humidity: "+weather_humidity);
            pressure_field.setText("Pressure: "+weather_pressure);
            weatherIcon.setText(Html.fromHtml(weather_iconText));

        }
    });

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Cuaca");

//        getLocationBtn = (Button) getView().findViewById(R.id.getLocationBtn);
//        locationText = (TextView) getView().findViewById(R.id.locationText);

        if (ContextCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }

//        getLocationBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getLocation();
//            }
//        });

        weatherFont = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView) getView().findViewById(R.id.city_field);
        updatedField = (TextView) getView().findViewById(R.id.updated_field);
        detailsField = (TextView) getView().findViewById(R.id.details_field);
        currentTemperatureField = (TextView) getView().findViewById(R.id.current_temperature_field);
        humidity_field = (TextView) getView().findViewById(R.id.humidity_field);
        pressure_field = (TextView) getView().findViewById(R.id.pressure_field);
        weatherIcon = (TextView) getView().findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);

//        asyncTask.execute("25.180000", "89.530000"); //  asyncTask.execute("Latitude", "Longitude")
        getLocation();

    }

    void getLocation() {
        try {
            TextView loading = (TextView) getView().findViewById(R.id.city_field);
            loading.setText("Memperbarui data");
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        } catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    public void onLocationChanged(Location location) {
        // locationText.setText("Latitude: " + location.getLatitude() + "\n Longitude: " + location.getLongitude());
        // asyncTask.execute("Latitude", "Longitude")
        this.lat = location.getLatitude() + "";
        this.lon = location.getLongitude() + "";
        try{
            Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
//            locationText.setText(addresses.get(0).getAddressLine(0) + ", " + addresses.get(0).getAddressLine(1) + ", " + addresses.get(0).getAddressLine(2));
            asyncTask.execute(this.lat, this.lon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(getActivity(), "Please Enable GPS and Internet", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_beranda, container, false);

    }

}
