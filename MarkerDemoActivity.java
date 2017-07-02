package com.example.goople4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import net.daum.mf.map.api.CalloutBalloonAdapter;
import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapPointBounds;
import net.daum.mf.map.api.MapView;

import java.util.Random;

public class MarkerDemoActivity extends Activity implements MapView.MapViewEventListener, MapView.POIItemEventListener {


    private int check = 0;
    private String name;

    private static final MapPoint CUSTOM_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.673801, 127.056014); //강강술래 상계점 (한식)
    private static final MapPoint DEFAULT_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6737412, 127.0525192); //수락이오냉면 (한식)
    private static final MapPoint MIA_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6348085, 127.070541); //참누렁소 (한식)
    private static final MapPoint no1_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6569678, 127.0652515);//육백식당 (한식)
    private static final MapPoint no2_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6264875, 127.0755798); //원조 이모네 연탄불곱창(한식)
    private static final MapPoint no3_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6181969, 127.0762627); //참만나(한식)
    private static final MapPoint no4_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.648391, 127.082957); //중계동 두부명가(한식)
    private static final MapPoint no5_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6541777, 127.0628928); //가로막집(한식)
    private static final MapPoint no6_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6288782, 127.0763504); //멍텅구리떡볶이(공릉점)(한식)
    private static final MapPoint no7_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6563898, 127.065335); //노원깡통(한식)
    private static final MapPoint no8_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6394973, 127.0753556); //향림(중식)
    private static final MapPoint no9_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6428149, 127.0664969); //마시내탕수육(중식)
    private static final MapPoint no10_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.656052, 127.0605807); //미도반점(중식)
    private static final MapPoint no11_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6153383, 127.0647673); //함지박(중식)
    private static final MapPoint no12_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6260315, 127.0731215); //뽕신(중식)
    private static final MapPoint no13_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6281924, 127.0702841); //미차이(중식)
    private static final MapPoint no14_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6216069, 127.0725134); //차이나팬(중식)
    private static final MapPoint no15_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6557526, 127.0643129); //경성양꼬치(중식)
    private static final MapPoint no16_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.662345, 127.0725643); //천화원(중식)
    private static final MapPoint no17_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6472927, 127.082096); //짜장마루(중식)
    private static final MapPoint no18_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6518951, 127.0795206); //정겨운오뎅집 (일식)
    private static final MapPoint no19_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6282798, 127.077779); //료쿠(일식)
    private static final MapPoint no20_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.654721, 127.0599985); //풍운일식(일식)
    private static final MapPoint no22_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6627831, 127.0660921); //큰바다횟집(일식)
    private static final MapPoint no24_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6612076, 127.074599); //돈까스먹는용만이(일식)
    private static final MapPoint no25_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.652905, 127.0605701);  //오니기리와이규동(일식)
    private static final MapPoint no27_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6390761, 127.0700774); //스시준(일식)
    private static final MapPoint no28_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.629469, 127.074714); //피자 굽는 언니(양식)
    private static final MapPoint no29_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.655020, 127.061219); //라이스앤라이스(양식)
    private static final MapPoint no30_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6202694, 127.0807898); //나르빅(양식)
    private static final MapPoint no31_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6370416, 127.0747754); //버거투버거(양식)
    private static final MapPoint no32_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6555778, 127.0642059); //제임스키친(양식)
    private static final MapPoint no33_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.654391, 127.0636736); //크라제 버거(양식)
    private static final MapPoint no34_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6521187, 127.0772126); //까르보네(양식)
    private static final MapPoint no35_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6550273, 127.0626121); //나우키친(양식)
    private static final MapPoint no36_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6558343, 127.0634116); //어글리스토브(양식)
    private static final MapPoint no37_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6409051, 127.0668572); //셀란키친(양식)
    private static final MapPoint no38_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.656614, 127.0635509); // 더 후라이팬(야식)
    private static final MapPoint no39_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6584306, 127.0737728); // 치어스(야식)
    private static final MapPoint no41_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.629469, 127.074714); //핏짜 굽는 언니(야식)
    private static final MapPoint no42_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6536806, 127.0647376); //피자꾼(야식)
    private static final MapPoint no43_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6267444, 127.0763624); //리틀파스타(야식)
    private static final MapPoint no44_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.626482, 127.0755743); //가장맛있는족발(야식)
    private static final MapPoint no45_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.656035, 127.0652336); //노원족발(야식)
    private static final MapPoint no47_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6149994, 127.0632343); //장군족발(야식)
    private static final MapPoint no48_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6560223, 127.064725); //윤씨네족보(야식)
    private static final MapPoint no50_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6265442, 127.0755958); //엉클스
    private static final MapPoint no52_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.661462, 127.066192); //오징어한마리매운떡볶이
    private static final MapPoint no53_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6261805, 127.0941737); //소라분식
    private static final MapPoint no54_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6565425, 127.0636909); //레드썬
    private static final MapPoint no55_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.656831, 127.0648162); //신전떡볶이
    private static final MapPoint no56_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6545367, 127.0629733); //고봉민김밥인
    private static final MapPoint no57_MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.6288846, 127.0763665); //멍텅구리즉석떡볶이


    private MapView mMapView;
    private MapPOIItem mDefaultMarker;
    private MapPOIItem mCustomMarker;
    private MapPOIItem mMiaMarker;
    private MapPOIItem mno1Marker;
    private MapPOIItem mno2Marker;
    private MapPOIItem mno3Marker;
    private MapPOIItem mno4Marker;
    private MapPOIItem mno5Marker;
    private MapPOIItem mno6Marker;
    private MapPOIItem mno7Marker;
    private MapPOIItem mno8Marker;
    private MapPOIItem mno9Marker;
    private MapPOIItem mno10Marker;
    private MapPOIItem mno11Marker;
    private MapPOIItem mno12Marker;
    private MapPOIItem mno13Marker;
    private MapPOIItem mno14Marker;
    private MapPOIItem mno15Marker;
    private MapPOIItem mno16Marker;
    private MapPOIItem mno17Marker;
    private MapPOIItem mno18Marker;
    private MapPOIItem mno19Marker;
    private MapPOIItem mno20Marker;
    private MapPOIItem mno22Marker;
    private MapPOIItem mno24Marker;
    private MapPOIItem mno25Marker;
    private MapPOIItem mno27Marker;
    private MapPOIItem mno28Marker;
    private MapPOIItem mno29Marker;
    private MapPOIItem mno30Marker;
    private MapPOIItem mno31Marker;
    private MapPOIItem mno32Marker;
    private MapPOIItem mno33Marker;
    private MapPOIItem mno34Marker;
    private MapPOIItem mno35Marker;
    private MapPOIItem mno36Marker;
    private MapPOIItem mno37Marker;
    private MapPOIItem mno38Marker;
    private MapPOIItem mno39Marker;
    private MapPOIItem mno41Marker;
    private MapPOIItem mno42Marker;
    private MapPOIItem mno43Marker;
    private MapPOIItem mno44Marker;
    private MapPOIItem mno45Marker;
    private MapPOIItem mno47Marker;
    private MapPOIItem mno48Marker;
    private MapPOIItem mno50Marker;
    private MapPOIItem mno52Marker;
    private MapPOIItem mno53Marker;
    private MapPOIItem mno54Marker;
    private MapPOIItem mno55Marker;
    private MapPOIItem mno56Marker;
    private MapPOIItem mno57Marker;
    private MapPOIItem selected;

    private MapPOIItem []selected_kor = {null, null, null, null, null, null, null, null, null, null, null};
    private MapPOIItem []selected_chi = {null, null, null, null, null, null, null, null, null, null, null};
    private MapPOIItem []selected_jap = {null, null, null, null, null, null, null, null};
    private MapPOIItem []selected_eur = {null, null, null, null, null, null, null, null, null, null, null};
    private MapPOIItem []selected_ya = {null, null, null, null, null, null, null, null, null, null};
    private MapPOIItem []selected_bun = {null, null, null, null, null, null, null, null};
    private MapPOIItem []result = {null, null, null, null, null, null, null};



    ToggleButton han,ch,ja,us,ni,bu;
    Button start;
    Random rr = new Random();


    public void MyGps(View view) {
        mMapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);
    }




    // CalloutBalloonAdapter 인터페이스 구현
    class CustomCalloutBalloonAdapter implements CalloutBalloonAdapter {
        private final View mCalloutBalloon;

        public CustomCalloutBalloonAdapter() {
            mCalloutBalloon = getLayoutInflater().inflate(R.layout.custom_callout_balloon, null);
        }

        @Override
        public View getCalloutBalloon(MapPOIItem poiItem) {
            ((ImageView) mCalloutBalloon.findViewById(R.id.badge)).setImageResource(R.drawable.ic_launcher);
            ((TextView) mCalloutBalloon.findViewById(R.id.title)).setText(poiItem.getItemName());
            ((TextView) mCalloutBalloon.findViewById(R.id.desc)).setText("");
            return mCalloutBalloon;

        }


        @Override
        public View getPressedCalloutBalloon(MapPOIItem poiItem) {
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.demo_nested_mapview);
        mMapView = (MapView) findViewById(R.id.map_view);
        mMapView.setDaumMapApiKey("9e864a6195a2376be9fa2792a726ca0b");
        mMapView.setMapViewEventListener(this);
        mMapView.setPOIItemEventListener(this);
        han = (ToggleButton) findViewById(R.id.kor);
        ch = (ToggleButton) findViewById(R.id.chi);
        ja = (ToggleButton) findViewById(R.id.jap);
        us = (ToggleButton) findViewById(R.id.usa);
        ni = (ToggleButton) findViewById(R.id.nig);
        bu = (ToggleButton) findViewById(R.id.bun);
        start = (Button) findViewById(R.id.start);





        // 구현한 CalloutBalloonAdapter 등록
        mMapView.setCalloutBalloonAdapter(new CustomCalloutBalloonAdapter());
        createrandomMarker(mMapView);
        createDefaultMarker(mMapView);
        createCustomMarker(mMapView);
        createMiaMarker(mMapView);
        createno1Marker(mMapView);
        createno2Marker(mMapView);
        createno3Marker(mMapView);
        createno4Marker(mMapView);
        createno5Marker(mMapView);
        createno6Marker(mMapView);
        createno7Marker(mMapView);
        createno8Marker(mMapView);
        createno9Marker(mMapView);
        createno10Marker(mMapView);
        createno11Marker(mMapView);
        createno12Marker(mMapView);
        createno13Marker(mMapView);
        createno14Marker(mMapView);
        createno15Marker(mMapView);
        createno16Marker(mMapView);
        createno17Marker(mMapView);
        createno18Marker(mMapView);
        createno19Marker(mMapView);
        createno20Marker(mMapView);
        createno22Marker(mMapView);
        createno24Marker(mMapView);
        createno25Marker(mMapView);
        createno27Marker(mMapView);
        createno28Marker(mMapView);
        createno29Marker(mMapView);
        createno30Marker(mMapView);
        createno31Marker(mMapView);
        createno32Marker(mMapView);
        createno33Marker(mMapView);
        createno34Marker(mMapView);
        createno35Marker(mMapView);
        createno36Marker(mMapView);
        createno37Marker(mMapView);
        createno38Marker(mMapView);
        createno39Marker(mMapView);
        createno41Marker(mMapView);
        createno42Marker(mMapView);
        createno43Marker(mMapView);
        createno44Marker(mMapView);
        createno45Marker(mMapView);
        createno47Marker(mMapView);
        createno48Marker(mMapView);
        createno50Marker(mMapView);
        createno52Marker(mMapView);
        createno53Marker(mMapView);
        createno54Marker(mMapView);
        createno55Marker(mMapView);
        createno56Marker(mMapView);
        createno57Marker(mMapView);


        showAll();
    }

    @Override
    public void onMapViewInitialized(MapView mapView) {

    }

    private void createDefaultMarker(MapView mapView){

       mDefaultMarker = new MapPOIItem();
        name = "강강술래";
        mDefaultMarker.setItemName(name);
        mDefaultMarker.setTag(0);
    }

    private void createCustomMarker(MapView mapView) {
        mCustomMarker = new MapPOIItem();
        name = "수락이오냉면";
        mCustomMarker.setItemName(name);
        mCustomMarker.setTag(1);
    }

    private void createMiaMarker(MapView mapView) {
        mMiaMarker = new MapPOIItem();
        name = "참누렁소";
        mMiaMarker.setItemName(name);
        mMiaMarker.setTag(3);
    }

    private void createno1Marker(MapView mapView) {
        mno1Marker = new MapPOIItem();
        name = "육백식당";
        mno1Marker.setItemName(name);
        mno1Marker.setTag(4);
    }

    private void createno2Marker(MapView mapView) {
        mno2Marker = new MapPOIItem();
        name = "원조 이모네 연탄불곱창";
        mno2Marker.setItemName(name);
        mno2Marker.setTag(5);
    }

    private void createno3Marker(MapView mapView) {
        mno3Marker = new MapPOIItem();
        name = "참만나";
        mno3Marker.setItemName(name);
        mno3Marker.setTag(6);
    }

    private void createno4Marker(MapView mapView) {
        mno4Marker = new MapPOIItem();
        name = "두부명가";
        mno4Marker.setItemName(name);
        mno4Marker.setTag(7);
    }

    private void createno5Marker(MapView mapView) {
        mno5Marker = new MapPOIItem();
        name = "가로막집";
        mno5Marker.setItemName(name);
        mno5Marker.setTag(8);
    }

    private void createno6Marker(MapView mapView) {
        mno6Marker = new MapPOIItem();
        name = "멍텅구리떡볶이";
        mno6Marker.setItemName(name);
        mno6Marker.setTag(9);
    }

    private void createno7Marker(MapView mapView) {
        mno7Marker = new MapPOIItem();
        name = "노원깡통";
        mno7Marker.setItemName(name);
        mno7Marker.setTag(10);
    }

    private void createno8Marker(MapView mapView) {
        mno8Marker = new MapPOIItem();
        name = "향림";
        mno8Marker.setItemName(name);
        mno8Marker.setTag(11);
    }

    private void createno9Marker(MapView mapView) {
        mno9Marker = new MapPOIItem();
        name = "마시내탕수육";
        mno9Marker.setItemName(name);
        mno9Marker.setTag(12);
    }

    private void createno10Marker(MapView mapView) {
        mno10Marker = new MapPOIItem();
        name = "미도반점";
        mno10Marker.setItemName(name);
        mno10Marker.setTag(13);
    }

    private void createno11Marker(MapView mapView) {
        mno11Marker = new MapPOIItem();
        name = "함지박";
        mno11Marker.setItemName(name);
        mno11Marker.setTag(14);
    }

    private void createno12Marker(MapView mapView) {
        mno12Marker = new MapPOIItem();
        name = "뽕신";
        mno12Marker.setItemName(name);
        mno12Marker.setTag(15);
    }

    private void createno13Marker(MapView mapView) {
        mno13Marker = new MapPOIItem();
        name = "미차이";
        mno13Marker.setItemName(name);
        mno13Marker.setTag(16);
    }

    private void createno14Marker(MapView mapView) {
        mno14Marker = new MapPOIItem();
        name = "차이나팬";
        mno14Marker.setItemName(name);
        mno14Marker.setTag(17);
    }

    private void createno15Marker(MapView mapView) {
        mno15Marker = new MapPOIItem();
        name = "경성양꼬치";
        mno15Marker.setItemName(name);
        mno15Marker.setTag(18);
    }

    private void createno16Marker(MapView mapView) {
        mno16Marker = new MapPOIItem();
        name = "천화원";
        mno16Marker.setItemName(name);
        mno16Marker.setTag(19);
    }

    private void createno17Marker(MapView mapView) {
        mno17Marker = new MapPOIItem();
        name = "짜장마루";
        mno17Marker.setItemName(name);
        mno17Marker.setTag(20);
    }

    private void createno18Marker(MapView mapView) {
        mno18Marker = new MapPOIItem();
        name = "정겨운오뎅집";
        mno18Marker.setItemName(name);
        mno18Marker.setTag(21);
    }

    private void createno19Marker(MapView mapView) {
        mno19Marker = new MapPOIItem();
        name = "료쿠";
        mno19Marker.setItemName(name);
        mno19Marker.setTag(22);
    }

    private void createno20Marker(MapView mapView) {
        mno20Marker = new MapPOIItem();
        name = "풍운일식";
        mno20Marker.setItemName(name);
        mno20Marker.setTag(23);
    }

    private void createno22Marker(MapView mapView) {
        mno22Marker = new MapPOIItem();
        name = "큰바다횟집";
        mno22Marker.setItemName(name);
        mno22Marker.setTag(25);
    }

    private void createno24Marker(MapView mapView) {
        mno24Marker = new MapPOIItem();
        name = "돈까스먹는용만이";
        mno24Marker.setItemName(name);
        mno24Marker.setTag(27);
    }

    private void createno25Marker(MapView mapView) {
        mno25Marker = new MapPOIItem();
        name = "오니기리와이규동";
        mno25Marker.setItemName(name);
        mno25Marker.setTag(28);
    }

    private void createno27Marker(MapView mapView) {
        mno27Marker = new MapPOIItem();
        name = "스시준";
        mno27Marker.setItemName(name);
        mno27Marker.setTag(30);
    }

    private void createno28Marker(MapView mapView) {
        mno28Marker = new MapPOIItem();
        name = "피자 굽는 언니";
        mno28Marker.setItemName(name);
        mno28Marker.setTag(31);
    }

    private void createno29Marker(MapView mapView) {
        mno29Marker = new MapPOIItem();
        name = "라이스앤라이스";
        mno29Marker.setItemName(name);
        mno29Marker.setTag(32);
    }

    private void createno30Marker(MapView mapView) {
        mno30Marker = new MapPOIItem();
        name = "나르빅";
        mno30Marker.setItemName(name);
        mno30Marker.setTag(33);
    }

    private void createno31Marker(MapView mapView) {
        mno31Marker = new MapPOIItem();
        name = "버거투버거";
        mno31Marker.setItemName(name);
        mno31Marker.setTag(34);
    }

    private void createno32Marker(MapView mapView) {
        mno32Marker = new MapPOIItem();
        name = "제임스키친";
        mno32Marker.setItemName(name);
        mno32Marker.setTag(35);
    }

    private void createno33Marker(MapView mapView) {
        mno33Marker = new MapPOIItem();
        name = "크라제 버거";
        mno33Marker.setItemName(name);
        mno33Marker.setTag(36);
    }

    private void createno34Marker(MapView mapView) {
        mno34Marker = new MapPOIItem();
        name = "까르보네";
        mno34Marker.setItemName(name);
        mno34Marker.setTag(37);
    }

    private void createno35Marker(MapView mapView) {
        mno35Marker = new MapPOIItem();
        name = "나우키친";
        mno35Marker.setItemName(name);
        mno35Marker.setTag(38);
    }

    private void createno36Marker(MapView mapView) {
        mno36Marker = new MapPOIItem();
        name = "어글리스토브";
        mno36Marker.setItemName(name);
        mno36Marker.setTag(39);
    }

    private void createno37Marker(MapView mapView) {
        mno37Marker = new MapPOIItem();
        name = "셀란키친";
        mno37Marker.setItemName(name);
        mno37Marker.setTag(40);
    }

    private void createno38Marker(MapView mapView) {
        mno38Marker = new MapPOIItem();
        name = "더 후라이팬";
        mno38Marker.setItemName(name);
        mno38Marker.setTag(41);
    }

    private void createno39Marker(MapView mapView) {
        mno39Marker = new MapPOIItem();
        name = "치어스";
        mno39Marker.setItemName(name);
        mno39Marker.setTag(42);
    }

    private void createno41Marker(MapView mapView) {
        mno41Marker = new MapPOIItem();
        name = "핏짜 굽는 언니";
        mno41Marker.setItemName(name);
        mno41Marker.setTag(44);
    }

    private void createno42Marker(MapView mapView) {
        mno42Marker = new MapPOIItem();
        name = "피자군";
        mno42Marker.setItemName(name);
        mno42Marker.setTag(45);
    }

    private void createno43Marker(MapView mapView) {
        mno43Marker = new MapPOIItem();
        name = "리틀파스타";
        mno43Marker.setItemName(name);
        mno43Marker.setTag(46);
    }

    private void createno44Marker(MapView mapView) {
        mno44Marker = new MapPOIItem();
        name = "가장맛있는족발";
        mno44Marker.setItemName(name);
        mno44Marker.setTag(47);
    }

    private void createno45Marker(MapView mapView) {
        mno45Marker = new MapPOIItem();
        name = "노원족발";
        mno45Marker.setItemName(name);
        mno45Marker.setTag(48);
    }

    private void createno47Marker(MapView mapView) {
        mno47Marker = new MapPOIItem();
        name = "장군족발";
        mno47Marker.setItemName(name);
        mno47Marker.setTag(50);
    }

    private void createno48Marker(MapView mapView) {
        mno48Marker = new MapPOIItem();
        name = "윤씨네족보";
        mno48Marker.setItemName(name);
        mno48Marker.setTag(51);
    }

    private void createno50Marker(MapView mapView) {
        mno50Marker = new MapPOIItem();
        name = "엉클스";
        mno50Marker.setItemName(name);
        mno50Marker.setTag(53);
    }

    private void createno52Marker(MapView mapView) {
        mno52Marker = new MapPOIItem();
        name = "오징어한마리매운떡볶이";
        mno52Marker.setItemName(name);
        mno52Marker.setTag(55);
    }

    private void createno53Marker(MapView mapView) {
        mno53Marker = new MapPOIItem();
        name = "소라분식";
        mno53Marker.setItemName(name);
        mno53Marker.setTag(56);
    }

    private void createno54Marker(MapView mapView) {
        mno54Marker = new MapPOIItem();
        name = "레드썬";
        mno54Marker.setItemName(name);
        mno54Marker.setTag(57);
    }

    private void createno55Marker(MapView mapView) {
        mno55Marker = new MapPOIItem();
        name = "신전떡볶이";
        mno55Marker.setItemName(name);
        mno55Marker.setTag(58);
    }

    private void createno56Marker(MapView mapView) {
        mno56Marker = new MapPOIItem();
        name = "고봉민김밥인";
        mno56Marker.setItemName(name);
        mno56Marker.setTag(59);
    }

    private void createno57Marker(MapView mapView) {
        mno57Marker = new MapPOIItem();
        name = "멍텅구리즉석떡볶이";
        mno57Marker.setItemName(name);
        mno57Marker.setTag(60);
    }

    public void createrandomMarker(final MapView mapView) {

//한식
        han.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//한식에 대한 토글버튼 이벤트

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (han.isChecked() == true) {//토글버튼(한)을 켰을 시
                    //지정된 마커의 위치를 불러온다.
                    mDefaultMarker.setMapPoint(CUSTOM_MARKER_POINT);
                    mCustomMarker.setMapPoint(DEFAULT_MARKER_POINT);
                    mMiaMarker.setMapPoint(MIA_MARKER_POINT);
                    mno1Marker.setMapPoint(no1_MARKER_POINT);
                    mno2Marker.setMapPoint(no2_MARKER_POINT);
                    mno3Marker.setMapPoint(no3_MARKER_POINT);
                    mno4Marker.setMapPoint(no4_MARKER_POINT);
                    mno5Marker.setMapPoint(no5_MARKER_POINT);
                    mno6Marker.setMapPoint(no6_MARKER_POINT);
                    mno7Marker.setMapPoint(no7_MARKER_POINT);
                    //지정된 위치에 해당된 마커의 색을 지정해 준다.
                    mDefaultMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mCustomMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mMiaMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno1Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno2Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno3Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno4Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno5Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno6Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno7Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    //마커의 위치를 단말기에 표시해 준다.
                    mapView.addPOIItem(mDefaultMarker);
                    mapView.addPOIItem(mCustomMarker);
                    mapView.addPOIItem(mMiaMarker);
                    mapView.addPOIItem(mno1Marker);
                    mapView.addPOIItem(mno2Marker);
                    mapView.addPOIItem(mno3Marker);
                    mapView.addPOIItem(mno4Marker);
                    mapView.addPOIItem(mno5Marker);
                    mapView.addPOIItem(mno6Marker);
                    mapView.addPOIItem(mno7Marker);

                    selected_kor[0] = mDefaultMarker;
                    selected_kor[1] = mCustomMarker;
                    selected_kor[2] = mMiaMarker;
                    selected_kor[3] = mno1Marker;
                    selected_kor[4] = mno2Marker;
                    selected_kor[5] = mno3Marker;
                    selected_kor[6] = mno4Marker;
                    selected_kor[7] = mno5Marker;
                    selected_kor[8] = mno6Marker;
                    selected_kor[9] = mno7Marker;

                    result[0] = selected_kor[rr.nextInt(10) + 0];
                    check += 1;
                    //mapView.selectPOIItem(mDefaultMarker, true);
                    // mapView.setMapCenterPoint(CUSTOM_MARKER_POINT, false);
                } else if (han.isChecked() == false) {//토글버튼(한)을 취소했을 시
                    //mDefaultMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    //표시됐던 마크들을 화면에서 제거한다.
                    mapView.removePOIItem(mDefaultMarker);
                    mapView.removePOIItem(mCustomMarker);
                    mapView.removePOIItem(mMiaMarker);
                    mapView.removePOIItem(mno1Marker);
                    mapView.removePOIItem(mno2Marker);
                    mapView.removePOIItem(mno3Marker);
                    mapView.removePOIItem(mno4Marker);
                    mapView.removePOIItem(mno5Marker);
                    mapView.removePOIItem(mno6Marker);
                    mapView.removePOIItem(mno7Marker);

                    result[0] = null;
                    check -= 1;
                }
            }
        });
//중식
        ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//중식에 대한 토글버튼 이벤트

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ch.isChecked() == true) {//토글버튼(중)을 켰을 시
                    //지정된 마커의 위치를 불러온다.
                    mno8Marker.setMapPoint(no8_MARKER_POINT);
                    mno9Marker.setMapPoint(no9_MARKER_POINT);
                    mno10Marker.setMapPoint(no10_MARKER_POINT);
                    mno11Marker.setMapPoint(no11_MARKER_POINT);
                    mno12Marker.setMapPoint(no12_MARKER_POINT);
                    mno13Marker.setMapPoint(no13_MARKER_POINT);
                    mno14Marker.setMapPoint(no14_MARKER_POINT);
                    mno15Marker.setMapPoint(no15_MARKER_POINT);
                    mno16Marker.setMapPoint(no16_MARKER_POINT);
                    mno17Marker.setMapPoint(no17_MARKER_POINT);
                    //지정된 위치에 해당된 마커의 색을 지정해 준다.
                    mno8Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno9Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno10Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno11Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno12Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno13Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno14Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno15Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno16Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno17Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    //마커의 위치를 단말기에 표시해 준다.
                    mapView.addPOIItem(mno8Marker);
                    mapView.addPOIItem(mno9Marker);
                    mapView.addPOIItem(mno10Marker);
                    mapView.addPOIItem(mno11Marker);
                    mapView.addPOIItem(mno12Marker);
                    mapView.addPOIItem(mno13Marker);
                    mapView.addPOIItem(mno14Marker);
                    mapView.addPOIItem(mno15Marker);
                    mapView.addPOIItem(mno16Marker);
                    mapView.addPOIItem(mno17Marker);

                    selected_chi[0] = mno8Marker;
                    selected_chi[1] = mno9Marker;
                    selected_chi[2] = mno10Marker;
                    selected_chi[3] = mno11Marker;
                    selected_chi[4] = mno12Marker;
                    selected_chi[5] = mno13Marker;
                    selected_chi[6] = mno14Marker;
                    selected_chi[7] = mno15Marker;
                    selected_chi[8] = mno16Marker;
                    selected_chi[9] = mno17Marker;

                    result[1] = selected_chi[rr.nextInt(10) + 0];
                    check += 1;
                    //mapView.selectPOIItem(mDefaultMarker, true);
                    // mapView.setMapCenterPoint(CUSTOM_MARKER_POINT, false);
                } else if (ch.isChecked() == false) {//토글버튼(중)을 취소했을 시
                    //mDefaultMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    //표시됐던 마크들을 화면에서 제거한다.
                    mapView.removePOIItem(mno8Marker);
                    mapView.removePOIItem(mno9Marker);
                    mapView.removePOIItem(mno10Marker);
                    mapView.removePOIItem(mno11Marker);
                    mapView.removePOIItem(mno12Marker);
                    mapView.removePOIItem(mno13Marker);
                    mapView.removePOIItem(mno14Marker);
                    mapView.removePOIItem(mno15Marker);
                    mapView.removePOIItem(mno16Marker);
                    mapView.removePOIItem(mno17Marker);

                    result[1] = null;
                    check -= 1;
                }
            }
        });
//일식
        ja.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//일식에 대한 토글버튼 이벤트

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ja.isChecked() == true) {//토글버튼(일)을 켰을 시
                    //지정된 마커의 위치를 불러온다.
                    mno18Marker.setMapPoint(no18_MARKER_POINT);
                    mno19Marker.setMapPoint(no19_MARKER_POINT);
                    mno20Marker.setMapPoint(no20_MARKER_POINT);
                    mno22Marker.setMapPoint(no22_MARKER_POINT);
                    mno24Marker.setMapPoint(no24_MARKER_POINT);
                    mno25Marker.setMapPoint(no25_MARKER_POINT);
                    mno27Marker.setMapPoint(no27_MARKER_POINT);
                    //지정된 위치에 해당된 마커의 색을 지정해 준다.
                    mno18Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno19Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno20Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno22Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno24Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno25Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno27Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    //마커의 위치를 단말기에 표시해 준다.
                    mapView.addPOIItem(mno18Marker);
                    mapView.addPOIItem(mno19Marker);
                    mapView.addPOIItem(mno20Marker);
                    mapView.addPOIItem(mno22Marker);
                    mapView.addPOIItem(mno24Marker);
                    mapView.addPOIItem(mno25Marker);
                    mapView.addPOIItem(mno27Marker);

                    selected_jap[0] = mno18Marker;
                    selected_jap[1] = mno19Marker;
                    selected_jap[2] = mno20Marker;
                    selected_jap[3] = mno22Marker;
                    selected_jap[4] = mno24Marker;
                    selected_jap[5] = mno25Marker;
                    selected_jap[6] = mno27Marker;

                    result[2] = selected_jap[rr.nextInt(7) + 0];
                    check += 1;
                    //mapView.selectPOIItem(mDefaultMarker, true);
                    // mapView.setMapCenterPoint(CUSTOM_MARKER_POINT, false);
                } else if (ja.isChecked() == false) {//토글버튼(일)을 취소했을 시
                    //mDefaultMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    //표시됐던 마크들을 화면에서 제거한다.
                    mapView.removePOIItem(mno18Marker);
                    mapView.removePOIItem(mno19Marker);
                    mapView.removePOIItem(mno20Marker);
                    mapView.removePOIItem(mno22Marker);
                    mapView.removePOIItem(mno24Marker);
                    mapView.removePOIItem(mno25Marker);
                    mapView.removePOIItem(mno27Marker);

                    result[2] = null;
                    check -= 1;
                }
            }
        });

        //양식
        us.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//양식에 대한 토글버튼 이벤트

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (us.isChecked() == true) {//토글버튼(양)을 켰을 시
                    //지정된 마커의 위치를 불러온다.
                    mno28Marker.setMapPoint(no28_MARKER_POINT);
                    mno29Marker.setMapPoint(no29_MARKER_POINT);
                    mno30Marker.setMapPoint(no30_MARKER_POINT);
                    mno31Marker.setMapPoint(no31_MARKER_POINT);
                    mno32Marker.setMapPoint(no32_MARKER_POINT);
                    mno33Marker.setMapPoint(no33_MARKER_POINT);
                    mno34Marker.setMapPoint(no34_MARKER_POINT);
                    mno35Marker.setMapPoint(no35_MARKER_POINT);
                    mno36Marker.setMapPoint(no36_MARKER_POINT);
                    mno37Marker.setMapPoint(no37_MARKER_POINT);
                    //지정된 위치에 해당된 마커의 색을 지정해 준다.
                    mno28Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno29Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno30Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno31Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno32Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno33Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno34Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno35Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno36Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    mno37Marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    //마커의 위치를 단말기에 표시해 준다.
                    mapView.addPOIItem(mno28Marker);
                    mapView.addPOIItem(mno29Marker);
                    mapView.addPOIItem(mno30Marker);
                    mapView.addPOIItem(mno31Marker);
                    mapView.addPOIItem(mno32Marker);
                    mapView.addPOIItem(mno33Marker);
                    mapView.addPOIItem(mno34Marker);
                    mapView.addPOIItem(mno35Marker);
                    mapView.addPOIItem(mno36Marker);
                    mapView.addPOIItem(mno37Marker);

                    selected_eur[0] = mno28Marker;
                    selected_eur[1] = mno29Marker;
                    selected_eur[2] = mno30Marker;
                    selected_eur[3] = mno31Marker;
                    selected_eur[4] = mno32Marker;
                    selected_eur[5] = mno33Marker;
                    selected_eur[6] = mno34Marker;
                    selected_eur[7] = mno35Marker;
                    selected_eur[8] = mno36Marker;
                    selected_eur[9] = mno37Marker;

                    result[3] = selected_eur[rr.nextInt(10) + 0];
                    check += 1;
                    //mapView.selectPOIItem(mDefaultMarker, true);
                    // mapView.setMapCenterPoint(CUSTOM_MARKER_POINT, false);
                } else if (us.isChecked() == false) {//토글버튼(양)을 취소했을 시
                    //mDefaultMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    //표시됐던 마크들을 화면에서 제거한다.
                    mapView.removePOIItem(mno28Marker);
                    mapView.removePOIItem(mno29Marker);
                    mapView.removePOIItem(mno30Marker);
                    mapView.removePOIItem(mno31Marker);
                    mapView.removePOIItem(mno32Marker);
                    mapView.removePOIItem(mno33Marker);
                    mapView.removePOIItem(mno34Marker);
                    mapView.removePOIItem(mno35Marker);
                    mapView.removePOIItem(mno36Marker);
                    mapView.removePOIItem(mno37Marker);

                    result[3] = null;
                    check -= 1;
                }
            }
        });

        //야식
        ni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//야식에 대한 토글버튼 이벤트

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ni.isChecked() == true) {//토글버튼(야)을 켰을 시
                    //지정된 마커의 위치를 불러온다.
                    mno38Marker.setMapPoint(no38_MARKER_POINT);
                    mno39Marker.setMapPoint(no39_MARKER_POINT);
                    mno41Marker.setMapPoint(no41_MARKER_POINT);
                    mno42Marker.setMapPoint(no42_MARKER_POINT);
                    mno43Marker.setMapPoint(no43_MARKER_POINT);
                    mno44Marker.setMapPoint(no44_MARKER_POINT);
                    mno45Marker.setMapPoint(no45_MARKER_POINT);
                    mno47Marker.setMapPoint(no47_MARKER_POINT);
                    mno48Marker.setMapPoint(no48_MARKER_POINT);
                    //지정된 위치에 해당된 마커의 색을 지정해 준다.
                    mno38Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno39Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno41Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno42Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno43Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno44Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno45Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno47Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    mno48Marker.setMarkerType(MapPOIItem.MarkerType.RedPin);
                    //마커의 위치를 단말기에 표시해 준다.
                    mapView.addPOIItem(mno38Marker);
                    mapView.addPOIItem(mno39Marker);
                    mapView.addPOIItem(mno41Marker);
                    mapView.addPOIItem(mno42Marker);
                    mapView.addPOIItem(mno43Marker);
                    mapView.addPOIItem(mno44Marker);
                    mapView.addPOIItem(mno45Marker);
                    mapView.addPOIItem(mno47Marker);
                    mapView.addPOIItem(mno48Marker);

                    selected_ya[0] = mno38Marker;
                    selected_ya[1] = mno39Marker;
                    selected_ya[2] = mno41Marker;
                    selected_ya[3] = mno42Marker;
                    selected_ya[4] = mno43Marker;
                    selected_ya[5] = mno44Marker;
                    selected_ya[6] = mno45Marker;
                    selected_ya[7] = mno47Marker;
                    selected_ya[8] = mno48Marker;

                    result[4] = selected_ya[rr.nextInt(9) + 0];
                    check += 1;
                    //mapView.selectPOIItem(mDefaultMarker, true);
                    // mapView.setMapCenterPoint(CUSTOM_MARKER_POINT, false);
                } else if (ni.isChecked() == false) {//토글버튼(야)을 취소했을 시
                    //mDefaultMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    //표시됐던 마크들을 화면에서 제거한다.
                    mapView.removePOIItem(mno38Marker);
                    mapView.removePOIItem(mno39Marker);
                    mapView.removePOIItem(mno41Marker);
                    mapView.removePOIItem(mno42Marker);
                    mapView.removePOIItem(mno43Marker);
                    mapView.removePOIItem(mno44Marker);
                    mapView.removePOIItem(mno45Marker);
                    mapView.removePOIItem(mno47Marker);
                    mapView.removePOIItem(mno48Marker);

                    result[4] = null;
                    check -= 1;
                }
            }
        });


        //분식
        bu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {//분식에 대한 토글버튼 이벤트

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bu.isChecked() == true) {//토글버튼(분)을 켰을 시
                    //지정된 마커의 위치를 불러온다.
                    mno50Marker.setMapPoint(no50_MARKER_POINT);
                    mno52Marker.setMapPoint(no52_MARKER_POINT);
                    mno53Marker.setMapPoint(no53_MARKER_POINT);
                    mno54Marker.setMapPoint(no54_MARKER_POINT);
                    mno55Marker.setMapPoint(no55_MARKER_POINT);
                    mno56Marker.setMapPoint(no56_MARKER_POINT);
                    mno57Marker.setMapPoint(no57_MARKER_POINT);
                    //지정된 위치에 해당된 마커의 색을 지정해 준다.
                    mno50Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno52Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno53Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno54Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno55Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno56Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    mno57Marker.setMarkerType(MapPOIItem.MarkerType.YellowPin);
                    //마커의 위치를 단말기에 표시해 준다.
                    mapView.addPOIItem(mno50Marker);
                    mapView.addPOIItem(mno52Marker);
                    mapView.addPOIItem(mno53Marker);
                    mapView.addPOIItem(mno54Marker);
                    mapView.addPOIItem(mno55Marker);
                    mapView.addPOIItem(mno56Marker);
                    mapView.addPOIItem(mno57Marker);

                    selected_bun[0] = mno50Marker;
                    selected_bun[1] = mno52Marker;
                    selected_bun[2] = mno53Marker;
                    selected_bun[3] = mno54Marker;
                    selected_bun[4] = mno55Marker;
                    selected_bun[5] = mno56Marker;
                    selected_bun[6] = mno57Marker;

                    result[5] = selected_bun[rr.nextInt(7) + 0];
                    check += 1;
                    //mapView.selectPOIItem(mDefaultMarker, true);
                    // mapView.setMapCenterPoint(CUSTOM_MARKER_POINT, false);
                } else if (bu.isChecked() == false) {//토글버튼(분)을 취소했을 시
                    //mDefaultMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                    //표시됐던 마크들을 화면에서 제거한다.
                    mapView.removePOIItem(mno50Marker);
                    mapView.removePOIItem(mno52Marker);
                    mapView.removePOIItem(mno53Marker);
                    mapView.removePOIItem(mno54Marker);
                    mapView.removePOIItem(mno55Marker);
                    mapView.removePOIItem(mno56Marker);
                    mapView.removePOIItem(mno57Marker);

                    result[5] = null;
                    check -= 1;
                }
            }
        });

    }

    private void showAll() {
        int padding = 1;
        float minZoomLevel = 4;
        float maxZoomLevel = 10;
        MapPointBounds bounds = new MapPointBounds(CUSTOM_MARKER_POINT, DEFAULT_MARKER_POINT);
        mMapView.moveCamera(CameraUpdateFactory.newMapPointBounds(bounds, padding, minZoomLevel, maxZoomLevel));
    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem) {

    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem) {
        //한식
        if(selected == mDefaultMarker){
            Intent s = new Intent(getApplicationContext(), korea1.class);
            startActivity(s);
        }
        else if(selected == mCustomMarker){
            Intent s = new Intent(getApplicationContext(), korea2.class);
            startActivity(s);
        }
        else if(selected == mMiaMarker){
            Intent s = new Intent(getApplicationContext(), korea3.class);
            startActivity(s);
        }
        else if(selected == mno1Marker){
            Intent s = new Intent(getApplicationContext(), korea4.class);
            startActivity(s);
        }
        else if(selected == mno2Marker){
            Intent s = new Intent(getApplicationContext(), korea5.class);
            startActivity(s);
        }
        else if(selected == mno3Marker){
            Intent s = new Intent(getApplicationContext(), korea6.class);
            startActivity(s);
        }
        else if(selected == mno4Marker){
            Intent s = new Intent(getApplicationContext(), korea7.class);
            startActivity(s);
        }
        else if(selected == mno5Marker){
            Intent s = new Intent(getApplicationContext(), korea8.class);
            startActivity(s);
        }
        else if(selected == mno6Marker){
            Intent s = new Intent(getApplicationContext(), korea9.class);
            startActivity(s);
        }
        else if(selected == mno7Marker){
            Intent s = new Intent(getApplicationContext(), korea10.class);
            startActivity(s);
        }
        //중식
        else if(selected == mno8Marker){
            Intent s = new Intent(getApplicationContext(), china1.class);
            startActivity(s);
        }
        else if(selected == mno9Marker){
            Intent s = new Intent(getApplicationContext(), china2.class);
            startActivity(s);
        }
        else if(selected == mno10Marker){
            Intent s = new Intent(getApplicationContext(), china3.class);
            startActivity(s);
        }
        else if(selected == mno11Marker){
            Intent s = new Intent(getApplicationContext(), china4.class);
            startActivity(s);
        }
        else if(selected == mno12Marker){
            Intent s = new Intent(getApplicationContext(), china5.class);
            startActivity(s);
        }
        else if(selected == mno13Marker){
            Intent s = new Intent(getApplicationContext(), china6.class);
            startActivity(s);
        }
        else if(selected == mno14Marker){
            Intent s = new Intent(getApplicationContext(), china7.class);
            startActivity(s);
        }
        else if(selected == mno15Marker){
            Intent s = new Intent(getApplicationContext(), china8.class);
            startActivity(s);
        }
        else if(selected == mno16Marker){
            Intent s = new Intent(getApplicationContext(), china9.class);
            startActivity(s);
        }
        else if(selected == mno17Marker){
            Intent s = new Intent(getApplicationContext(), china10.class);
            startActivity(s);
        }
        //일식
        else if(selected == mno18Marker){
            Intent s = new Intent(getApplicationContext(), japan1.class);
            startActivity(s);
        }
        else if(selected == mno19Marker){
            Intent s = new Intent(getApplicationContext(), japan2.class);
            startActivity(s);
        }
        else if(selected == mno20Marker){
            Intent s = new Intent(getApplicationContext(), japan3.class);
            startActivity(s);
        }
        else if(selected == mno22Marker){
            Intent s = new Intent(getApplicationContext(), japan6.class);
            startActivity(s);
        }
        else if(selected == mno24Marker){
            Intent s = new Intent(getApplicationContext(), japan7.class);
            startActivity(s);
        }
        else if(selected == mno25Marker){
            Intent s = new Intent(getApplicationContext(), japan8.class);
            startActivity(s);
        }
        else if(selected == mno27Marker){
            Intent s = new Intent(getApplicationContext(), japan10.class);
            startActivity(s);
        }
        //양식
        else if(selected == mno28Marker){
            Intent s = new Intent(getApplicationContext(), west1.class);
            startActivity(s);
        }
        else if(selected == mno29Marker){
            Intent s = new Intent(getApplicationContext(), west2.class);
            startActivity(s);
        }
        else if(selected == mno30Marker){
            Intent s = new Intent(getApplicationContext(), west3.class);
            startActivity(s);
        }
        else if(selected == mno31Marker){
            Intent s = new Intent(getApplicationContext(), west4.class);
            startActivity(s);
        }
        else if(selected == mno32Marker){
            Intent s = new Intent(getApplicationContext(), west5.class);
            startActivity(s);
        }
        else if(selected == mno33Marker){
            Intent s = new Intent(getApplicationContext(), west6.class);
            startActivity(s);
        }
        else if(selected == mno34Marker){
            Intent s = new Intent(getApplicationContext(), west7.class);
            startActivity(s);
        }
        else if(selected == mno35Marker){
            Intent s = new Intent(getApplicationContext(), west8.class);
            startActivity(s);
        }
        else if(selected == mno36Marker){
            Intent s = new Intent(getApplicationContext(), west9.class);
            startActivity(s);
        }
        else if(selected == mno37Marker){
            Intent s = new Intent(getApplicationContext(), west10.class);
            startActivity(s);
        }
        //야식
        else if(selected == mno38Marker){
            Intent s = new Intent(getApplicationContext(), night1.class);
            startActivity(s);
        }
        else if(selected == mno39Marker){
            Intent s = new Intent(getApplicationContext(), night2.class);
            startActivity(s);
        }
        else if(selected == mno41Marker){
            Intent s = new Intent(getApplicationContext(), west1.class);
            startActivity(s);
        }
        else if(selected == mno42Marker){
            Intent s = new Intent(getApplicationContext(), night4.class);
            startActivity(s);
        }
        else if(selected == mno43Marker){
            Intent s = new Intent(getApplicationContext(), night5.class);
            startActivity(s);
        }
        else if(selected == mno44Marker){
            Intent s = new Intent(getApplicationContext(), night6.class);
            startActivity(s);
        }
        else if(selected == mno45Marker){
            Intent s = new Intent(getApplicationContext(), night7.class);
            startActivity(s);
        }
        else if(selected == mno47Marker){
            Intent s = new Intent(getApplicationContext(), night8.class);
            startActivity(s);
        }
        else if(selected == mno48Marker){
            Intent s = new Intent(getApplicationContext(), night10.class);
            startActivity(s);
        }
        //분식
        else if(selected == mno50Marker){
            Intent s = new Intent(getApplicationContext(), bun2.class);
            startActivity(s);
        }
        else if(selected == mno52Marker){
            Intent s = new Intent(getApplicationContext(), bun4.class);
            startActivity(s);
        }
        else if(selected == mno53Marker){
            Intent s = new Intent(getApplicationContext(), bun5.class);
            startActivity(s);
        }
        else if(selected == mno54Marker){
            Intent s = new Intent(getApplicationContext(), bun6.class);
            startActivity(s);
        }
        else if(selected == mno55Marker){
            Intent s = new Intent(getApplicationContext(), bun7.class);
            startActivity(s);
        }
        else if(selected == mno56Marker){
            Intent s = new Intent(getApplicationContext(), bun8.class);
            startActivity(s);
        }
        else if(selected == mno57Marker){
            Intent s = new Intent(getApplicationContext(), bun9.class);
            startActivity(s);
        }
    }

    @Override
    public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem mapPOIItem, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {

    }

    @Override
    public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem mapPOIItem, MapPoint mapPoint) {

    }

    public void res(View v){
        if(check !=0){
            boolean i = true;
            mMapView.removeAllPOIItems();
            while(i){
                selected = result[rr.nextInt(6) + 0];
                if(selected != null){
                    mMapView.addPOIItem(selected);
                    han.setVisibility(View.INVISIBLE);
                    ch.setVisibility(View.INVISIBLE);
                    ja.setVisibility(View.INVISIBLE);
                    us.setVisibility(View.INVISIBLE);
                    ni.setVisibility(View.INVISIBLE);
                    bu.setVisibility(View.INVISIBLE);
                    start.setVisibility(View.INVISIBLE);
                    i = false;
                }
            }
        }
    }
}
