package com.android.betterway.showscheduleactivity.view;


import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.android.betterway.R;
import com.android.betterway.other.MapMarker;
import com.android.betterway.utils.ToastUtil;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleMapFragment extends Fragment {
    @BindView(R.id.mapShow)
    MapView mMapShow;
    Unbinder unbinder;
    private AMap mAMap;
    List<LatLng> mLatLngList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_map, container, false);
        unbinder = ButterKnife.bind(this, view);
        mMapShow.onCreate(savedInstanceState);
        mLatLngList = this.getArguments().getParcelableArrayList("latlnglist");
        initMap();
        initLatLng();
        return view;
    }

    /**
     * 初始化坐标
     */
    private void initLatLng() {
        for (int i = 0; i < mLatLngList.size(); i++) {
            Marker marker = mAMap.addMarker(new MarkerOptions());
            marker.setPosition(mLatLngList.get(i));
            marker.setTitle(String.valueOf(i + 1));
            mAMap.moveCamera(CameraUpdateFactory.changeLatLng(mLatLngList.get(0)));
            mAMap.moveCamera(CameraUpdateFactory.zoomTo(13));
        }
    }

    /**
     * 初始化地图
     */
    private void initMap() {
        if (mAMap == null) {
            mAMap = mMapShow.getMap();
        }
        //mAMap.getUiSettings().setZoomControlsEnabled(false);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mMapShow.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapShow.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapShow.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapShow.onPause();
    }

}
