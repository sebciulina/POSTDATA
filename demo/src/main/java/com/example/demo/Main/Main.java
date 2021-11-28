package com.example.demo.Main;

import com.example.demo.Converter.FirstPointConverter;
import com.example.demo.Converter.PointsConverter;
import com.example.demo.JsonReader;
import com.example.demo.Point.FirstPoint;
import com.example.demo.Point.Points;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        FirstPointConverter firstPointConverter = new FirstPointConverter();
        PointsConverter pointsConverter = new PointsConverter();
        pointsConverter.convert();
        firstPointConverter.convert();

        List<Points> wGdyni = pointsConverter.getPointsList().stream().filter(points -> points.getCity().equals("Gdynia")).toList();
        List<Points> wSopocie = pointsConverter.getPointsList().stream().filter(points -> points.getCity().equals("Sopot")).toList();
        List<Points> wGdansku = pointsConverter.getPointsList().stream().filter(points -> points.getCity().equals("Gdańsk")).toList();
        System.out.println(wGdyni);
        System.out.println(wSopocie);
        System.out.println(wGdansku);

        JsonReader reader = new JsonReader();

        //gdynia sopot najkrocej
        HashMap<Points,String> pointsHashMap = new HashMap<>();
        HashMap<Integer, HashMap<Points,String>> hashMap = new HashMap<>();
        int i = 1;
        FirstPoint firstPoint = firstPointConverter.getStartPoint();
        for (Points point:wSopocie){
            String path = "https://maps.googleapis.com/maps/api/directions/json?destination="+firstPoint.getCity()+"+"+firstPoint.getStreet().replaceAll(" ","")+"+"+firstPoint.getStreetNumber()+"&origin="+point.getCity()+"+"+point.getStreet().replaceAll(" ","")+"+"+point.getStreetNumber()+"&key=tutajPodacKey";
            System.out.println(path);
            JSONObject jsonObject = new JSONObject("{\"routes\":[{\"summary\":\"droga Gdyńska\",\"copyrights\":\"Map data ©2021 Google\",\"legs\":[{\"duration\":{\"text\":\"11 mins\",\"value\":669},\"start_location\":{\"lng\":18.5194111,\"lat\":54.4781366},\"distance\":{\"text\":\"6.1 km\",\"value\":6051},\"start_address\":\"Witolda 17, 81-532 Gdynia, Poland\",\"end_location\":{\"lng\":18.5389784,\"lat\":54.5205912},\"end_address\":\"Władysława IV 24, 81-384 Gdynia, Poland\",\"via_waypoint\":[],\"steps\":[{\"duration\":{\"text\":\"1 min\",\"value\":39},\"start_location\":{\"lng\":18.5194111,\"lat\":54.4781366},\"distance\":{\"text\":\"0.2 km\",\"value\":202},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Head <b>northeast<\\/b> on <b>Witolda<\\/b> toward <b>Gedymina<\\/b>\",\"end_location\":{\"lng\":18.5220427,\"lat\":54.4790393},\"polyline\":{\"points\":\"kgokIia`pBACGS[_AGMq@sBa@kASo@GSEMEUCKAG?GC]?c@?a@\"}},{\"duration\":{\"text\":\"1 min\",\"value\":41},\"start_location\":{\"lng\":18.5220427,\"lat\":54.4790393},\"distance\":{\"text\":\"0.1 km\",\"value\":140},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Turn <b>right<\\/b> onto <b>Gedymina<\\/b>\",\"end_location\":{\"lng\":18.5226601,\"lat\":54.4779255},\"maneuver\":\"turn-right\",\"polyline\":{\"points\":\"_mokIwq`pBNNFDDBFBJ@F?F?DAJEZUjAqANSPW\"}},{\"duration\":{\"text\":\"2 mins\",\"value\":137},\"start_location\":{\"lng\":18.5226601,\"lat\":54.4779255},\"distance\":{\"text\":\"1.4 km\",\"value\":1418},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Turn <b>left<\\/b> onto <b>Wielkopolska<\\/b>\\/<wbr\\/><b>DW474<\\/b>\",\"end_location\":{\"lng\":18.5414209,\"lat\":54.4842094},\"maneuver\":\"turn-left\",\"polyline\":{\"points\":\"afokIsu`pBPOmCmKsBkImAaFgAsE{@qD_@yAaAaCoAqCKSy@kBu@qB}AeIq@iDaB_JsA_HWsAUgA]iB?SAIEQc@gCa@sBWsA\"}},{\"duration\":{\"text\":\"1 min\",\"value\":63},\"start_location\":{\"lng\":18.5414209,\"lat\":54.4842094},\"distance\":{\"text\":\"0.7 km\",\"value\":738},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Turn <b>left<\\/b> onto <b>Lotników<\\/b>\",\"end_location\":{\"lng\":18.5382834,\"lat\":54.490489},\"maneuver\":\"turn-left\",\"polyline\":{\"points\":\"impkI{jdpBCMCMMJ[TCB}AfAUN{@n@s@b@s@`@sAl@cA`@A@iA^qA`@}DbAgBb@}@Xs@TqAd@}@`@{@f@\"}},{\"duration\":{\"text\":\"2 mins\",\"value\":98},\"start_location\":{\"lng\":18.5382834,\"lat\":54.490489},\"distance\":{\"text\":\"1.6 km\",\"value\":1643},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Continue onto <b>droga Gdyńska<\\/b>\",\"end_location\":{\"lng\":18.5341166,\"lat\":54.504652},\"polyline\":{\"points\":\"qtqkIgwcpByA|@g@Xe@Xg@Tg@T_@LEBWH[HYH_@H]HoCj@k@JiDr@eAV_AT]J_@J_@J]Ly@Xw@X{Bz@{Bx@c@Nc@R[NYP]Za@^c@h@c@l@]b@CFYXWXGDSRe@Zc@Xq@Xq@T_@HK@UBo@DI@c@AYAk@C]GUEkCo@o@Qa@KyGeBy@Sc@K\"}},{\"duration\":{\"text\":\"1 min\",\"value\":56},\"start_location\":{\"lng\":18.5341166,\"lat\":54.504652},\"distance\":{\"text\":\"0.3 km\",\"value\":288},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Slight <b>right<\\/b> to stay on <b>droga Gdyńska<\\/b>\",\"end_location\":{\"lng\":18.5360438,\"lat\":54.5064819},\"maneuver\":\"turn-slight-right\",\"polyline\":{\"points\":\"amtkIg}bpBOQQKa@QUG[Gk@GMCg@EiBSGCEAEGEEEICIAEIm@@eB?W@a@?]\"}},{\"duration\":{\"text\":\"1 min\",\"value\":63},\"start_location\":{\"lng\":18.5360438,\"lat\":54.5064819},\"distance\":{\"text\":\"0.4 km\",\"value\":386},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Continue straight onto <b>aleja Zwycięstwa<\\/b>\\/<wbr\\/><b>DW468<\\/b>\",\"end_location\":{\"lng\":18.5370266,\"lat\":54.5095591},\"maneuver\":\"straight\",\"polyline\":{\"points\":\"oxtkIgicpB?eA?_@Ge@AA[MWIu@I[EY?oAC[Be@AS?C?e@@_C?aAC[?OK\"}},{\"duration\":{\"text\":\"3 mins\",\"value\":172},\"start_location\":{\"lng\":18.5370266,\"lat\":54.5095591},\"distance\":{\"text\":\"1.2 km\",\"value\":1236},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Continue straight onto <b>Władysława IV<\\/b><div style=\\\"font-size:0.9em\\\">Destination will be on the left<\\/div>\",\"end_location\":{\"lng\":18.5389784,\"lat\":54.5205912},\"maneuver\":\"straight\",\"polyline\":{\"points\":\"wkukImocpBe@KOC[I_GsAc@I[GWEUCuB[{@K{@KsAOk@Ie@E}@KyAQ{@K_@GwBW_AKa@EYE_AMaAKMCs@IaAKUCMAc@AgA@aA?uA?o@Co@CcBE[CQ?aAD\"}}],\"traffic_speed_entry\":[]}],\"warnings\":[],\"bounds\":{\"southwest\":{\"lng\":18.5194111,\"lat\":54.4778365},\"northeast\":{\"lng\":18.5415563,\"lat\":54.5205912}},\"overview_polyline\":{\"points\":\"kgokIia`pBuCuIWcAAOCaA?a@NNLHRDN?PGZUjAqA`@k@POmCmKaEmPcCeK_@yAaAaC{AeDy@kBu@qBoCoNuD_Sm@{C]iB?SG[aB}ICMMJ_@XsBvAoBrAgCnAeAb@{C`AeHfBqBn@qAd@}@`@uCdBmAr@uB|@mBf@cKtBcEdAoDlA{GdC_Ab@w@l@eAhAaApA}@`Ay@n@uAr@qA^a@Dy@F}@CiAKaDu@eLwCc@KOQs@]q@Oy@KqCYMEKMISKs@@}B@eDIg@s@WqAOiBCyA@eD@}ACOKe@Kk@McH}As@McGw@cFk@iNcBeEe@c@EkB?wC?_BG_CIsAD\"},\"waypoint_order\":[]}],\"geocoded_waypoints\":[{\"types\":[\"street_address\"],\"geocoder_status\":\"OK\",\"place_id\":\"ChIJZ2FIjO6g_UYRxx642XSl6pY\"},{\"types\":[\"street_address\"],\"geocoder_status\":\"OK\",\"place_id\":\"ChIJ8YAk-CSn_UYRb8dapNObl8o\"}],\"status\":\"OK\"}\n");
            pointsHashMap.put(point,jsonObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").get("value").toString());
            i++;
            System.out.println(i);
            if (i==51){
                break;
            }
        }
        hashMap.put(1,pointsHashMap);
        System.out.println(hashMap.get(1));
        int j = 1;
        long l=9999;
        Points closeSopot = new Points();
        for (Points point:wSopocie){
            if (Long.parseLong(hashMap.get(1).get(point))<l){
                l = Long.parseLong(hashMap.get(j).get(point));
                System.out.println("wchodze");
                closeSopot = point;
            }
        }
        System.out.println(l);
        System.out.println(closeSopot);

        //sopot-gdansk najkrocej

        HashMap<Points,String> pointsHashMap1 = new HashMap<>();
        HashMap<Integer, HashMap<Points,String>> hashMap1 = new HashMap<>();
        int help = 1;
        Points firstPoint1 = closeSopot;
        for (Points point:wGdansku){
            String path = "https://maps.googleapis.com/maps/api/directions/json?destination="+firstPoint1.getCity()+"+"+firstPoint1.getStreet().replaceAll(" ","")+"+"+firstPoint1.getStreetNumber()+"&origin="+point.getCity()+"+"+point.getStreet().replaceAll(" ","")+"+"+point.getStreetNumber()+"&key=tutajPodacKey";
            System.out.println(path);
            JSONObject jsonObject = new JSONObject("{\"routes\":[{\"summary\":\"droga Gdyńska\",\"copyrights\":\"Map data ©2021 Google\",\"legs\":[{\"duration\":{\"text\":\"11 mins\",\"value\":669},\"start_location\":{\"lng\":18.5194111,\"lat\":54.4781366},\"distance\":{\"text\":\"6.1 km\",\"value\":6051},\"start_address\":\"Witolda 17, 81-532 Gdynia, Poland\",\"end_location\":{\"lng\":18.5389784,\"lat\":54.5205912},\"end_address\":\"Władysława IV 24, 81-384 Gdynia, Poland\",\"via_waypoint\":[],\"steps\":[{\"duration\":{\"text\":\"1 min\",\"value\":39},\"start_location\":{\"lng\":18.5194111,\"lat\":54.4781366},\"distance\":{\"text\":\"0.2 km\",\"value\":202},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Head <b>northeast<\\/b> on <b>Witolda<\\/b> toward <b>Gedymina<\\/b>\",\"end_location\":{\"lng\":18.5220427,\"lat\":54.4790393},\"polyline\":{\"points\":\"kgokIia`pBACGS[_AGMq@sBa@kASo@GSEMEUCKAG?GC]?c@?a@\"}},{\"duration\":{\"text\":\"1 min\",\"value\":41},\"start_location\":{\"lng\":18.5220427,\"lat\":54.4790393},\"distance\":{\"text\":\"0.1 km\",\"value\":140},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Turn <b>right<\\/b> onto <b>Gedymina<\\/b>\",\"end_location\":{\"lng\":18.5226601,\"lat\":54.4779255},\"maneuver\":\"turn-right\",\"polyline\":{\"points\":\"_mokIwq`pBNNFDDBFBJ@F?F?DAJEZUjAqANSPW\"}},{\"duration\":{\"text\":\"2 mins\",\"value\":137},\"start_location\":{\"lng\":18.5226601,\"lat\":54.4779255},\"distance\":{\"text\":\"1.4 km\",\"value\":1418},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Turn <b>left<\\/b> onto <b>Wielkopolska<\\/b>\\/<wbr\\/><b>DW474<\\/b>\",\"end_location\":{\"lng\":18.5414209,\"lat\":54.4842094},\"maneuver\":\"turn-left\",\"polyline\":{\"points\":\"afokIsu`pBPOmCmKsBkImAaFgAsE{@qD_@yAaAaCoAqCKSy@kBu@qB}AeIq@iDaB_JsA_HWsAUgA]iB?SAIEQc@gCa@sBWsA\"}},{\"duration\":{\"text\":\"1 min\",\"value\":63},\"start_location\":{\"lng\":18.5414209,\"lat\":54.4842094},\"distance\":{\"text\":\"0.7 km\",\"value\":738},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Turn <b>left<\\/b> onto <b>Lotników<\\/b>\",\"end_location\":{\"lng\":18.5382834,\"lat\":54.490489},\"maneuver\":\"turn-left\",\"polyline\":{\"points\":\"impkI{jdpBCMCMMJ[TCB}AfAUN{@n@s@b@s@`@sAl@cA`@A@iA^qA`@}DbAgBb@}@Xs@TqAd@}@`@{@f@\"}},{\"duration\":{\"text\":\"2 mins\",\"value\":98},\"start_location\":{\"lng\":18.5382834,\"lat\":54.490489},\"distance\":{\"text\":\"1.6 km\",\"value\":1643},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Continue onto <b>droga Gdyńska<\\/b>\",\"end_location\":{\"lng\":18.5341166,\"lat\":54.504652},\"polyline\":{\"points\":\"qtqkIgwcpByA|@g@Xe@Xg@Tg@T_@LEBWH[HYH_@H]HoCj@k@JiDr@eAV_AT]J_@J_@J]Ly@Xw@X{Bz@{Bx@c@Nc@R[NYP]Za@^c@h@c@l@]b@CFYXWXGDSRe@Zc@Xq@Xq@T_@HK@UBo@DI@c@AYAk@C]GUEkCo@o@Qa@KyGeBy@Sc@K\"}},{\"duration\":{\"text\":\"1 min\",\"value\":56},\"start_location\":{\"lng\":18.5341166,\"lat\":54.504652},\"distance\":{\"text\":\"0.3 km\",\"value\":288},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Slight <b>right<\\/b> to stay on <b>droga Gdyńska<\\/b>\",\"end_location\":{\"lng\":18.5360438,\"lat\":54.5064819},\"maneuver\":\"turn-slight-right\",\"polyline\":{\"points\":\"amtkIg}bpBOQQKa@QUG[Gk@GMCg@EiBSGCEAEGEEEICIAEIm@@eB?W@a@?]\"}},{\"duration\":{\"text\":\"1 min\",\"value\":63},\"start_location\":{\"lng\":18.5360438,\"lat\":54.5064819},\"distance\":{\"text\":\"0.4 km\",\"value\":386},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Continue straight onto <b>aleja Zwycięstwa<\\/b>\\/<wbr\\/><b>DW468<\\/b>\",\"end_location\":{\"lng\":18.5370266,\"lat\":54.5095591},\"maneuver\":\"straight\",\"polyline\":{\"points\":\"oxtkIgicpB?eA?_@Ge@AA[MWIu@I[EY?oAC[Be@AS?C?e@@_C?aAC[?OK\"}},{\"duration\":{\"text\":\"3 mins\",\"value\":172},\"start_location\":{\"lng\":18.5370266,\"lat\":54.5095591},\"distance\":{\"text\":\"1.2 km\",\"value\":1236},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Continue straight onto <b>Władysława IV<\\/b><div style=\\\"font-size:0.9em\\\">Destination will be on the left<\\/div>\",\"end_location\":{\"lng\":18.5389784,\"lat\":54.5205912},\"maneuver\":\"straight\",\"polyline\":{\"points\":\"wkukImocpBe@KOC[I_GsAc@I[GWEUCuB[{@K{@KsAOk@Ie@E}@KyAQ{@K_@GwBW_AKa@EYE_AMaAKMCs@IaAKUCMAc@AgA@aA?uA?o@Co@CcBE[CQ?aAD\"}}],\"traffic_speed_entry\":[]}],\"warnings\":[],\"bounds\":{\"southwest\":{\"lng\":18.5194111,\"lat\":54.4778365},\"northeast\":{\"lng\":18.5415563,\"lat\":54.5205912}},\"overview_polyline\":{\"points\":\"kgokIia`pBuCuIWcAAOCaA?a@NNLHRDN?PGZUjAqA`@k@POmCmKaEmPcCeK_@yAaAaC{AeDy@kBu@qBoCoNuD_Sm@{C]iB?SG[aB}ICMMJ_@XsBvAoBrAgCnAeAb@{C`AeHfBqBn@qAd@}@`@uCdBmAr@uB|@mBf@cKtBcEdAoDlA{GdC_Ab@w@l@eAhAaApA}@`Ay@n@uAr@qA^a@Dy@F}@CiAKaDu@eLwCc@KOQs@]q@Oy@KqCYMEKMISKs@@}B@eDIg@s@WqAOiBCyA@eD@}ACOKe@Kk@McH}As@McGw@cFk@iNcBeEe@c@EkB?wC?_BG_CIsAD\"},\"waypoint_order\":[]}],\"geocoded_waypoints\":[{\"types\":[\"street_address\"],\"geocoder_status\":\"OK\",\"place_id\":\"ChIJZ2FIjO6g_UYRxx642XSl6pY\"},{\"types\":[\"street_address\"],\"geocoder_status\":\"OK\",\"place_id\":\"ChIJ8YAk-CSn_UYRb8dapNObl8o\"}],\"status\":\"OK\"}\n");
            pointsHashMap1.put(point,jsonObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").get("value").toString());
            System.out.println("podałem");
            help++;
            System.out.println(help);
            if (help==51){
                break;
            }
        }
        hashMap1.put(1,pointsHashMap1);
        System.out.println(hashMap1.get(1));
        int jj = 1;
        long ll=9999;
        Points closeGdansk = new Points();
        for (Points point:wGdansku){
            if (Long.parseLong(hashMap1.get(jj).get(point))<ll){
                ll = Long.parseLong(hashMap1.get(jj).get(point));
                closeGdansk = point;
                System.out.println("sss");
            }
        }
        System.out.println(ll);
        System.out.println(closeGdansk);

        //gdańsk-krótka gańsk długa
        HashMap<Points,String> pointsHashMap2 = new HashMap<>();
        HashMap<Integer, HashMap<Points,String>> hashMap2 = new HashMap<>();
        int help2 = 1;
        Points firstPoint2 = closeGdansk;
        for (Points point:wGdansku){
            String path = "https://maps.googleapis.com/maps/api/directions/json?destination="+firstPoint2.getCity()+"+"+firstPoint2.getStreet().replaceAll(" ","")+"+"+firstPoint2.getStreetNumber()+"&origin="+point.getCity()+"+"+point.getStreet().replaceAll(" ","")+"+"+point.getStreetNumber()+"&key=tutajPodacKey";
            System.out.println(path);
            JSONObject jsonObject = new JSONObject("{\"routes\":[{\"summary\":\"droga Gdyńska\",\"copyrights\":\"Map data ©2021 Google\",\"legs\":[{\"duration\":{\"text\":\"11 mins\",\"value\":669},\"start_location\":{\"lng\":18.5194111,\"lat\":54.4781366},\"distance\":{\"text\":\"6.1 km\",\"value\":6051},\"start_address\":\"Witolda 17, 81-532 Gdynia, Poland\",\"end_location\":{\"lng\":18.5389784,\"lat\":54.5205912},\"end_address\":\"Władysława IV 24, 81-384 Gdynia, Poland\",\"via_waypoint\":[],\"steps\":[{\"duration\":{\"text\":\"1 min\",\"value\":39},\"start_location\":{\"lng\":18.5194111,\"lat\":54.4781366},\"distance\":{\"text\":\"0.2 km\",\"value\":202},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Head <b>northeast<\\/b> on <b>Witolda<\\/b> toward <b>Gedymina<\\/b>\",\"end_location\":{\"lng\":18.5220427,\"lat\":54.4790393},\"polyline\":{\"points\":\"kgokIia`pBACGS[_AGMq@sBa@kASo@GSEMEUCKAG?GC]?c@?a@\"}},{\"duration\":{\"text\":\"1 min\",\"value\":41},\"start_location\":{\"lng\":18.5220427,\"lat\":54.4790393},\"distance\":{\"text\":\"0.1 km\",\"value\":140},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Turn <b>right<\\/b> onto <b>Gedymina<\\/b>\",\"end_location\":{\"lng\":18.5226601,\"lat\":54.4779255},\"maneuver\":\"turn-right\",\"polyline\":{\"points\":\"_mokIwq`pBNNFDDBFBJ@F?F?DAJEZUjAqANSPW\"}},{\"duration\":{\"text\":\"2 mins\",\"value\":137},\"start_location\":{\"lng\":18.5226601,\"lat\":54.4779255},\"distance\":{\"text\":\"1.4 km\",\"value\":1418},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Turn <b>left<\\/b> onto <b>Wielkopolska<\\/b>\\/<wbr\\/><b>DW474<\\/b>\",\"end_location\":{\"lng\":18.5414209,\"lat\":54.4842094},\"maneuver\":\"turn-left\",\"polyline\":{\"points\":\"afokIsu`pBPOmCmKsBkImAaFgAsE{@qD_@yAaAaCoAqCKSy@kBu@qB}AeIq@iDaB_JsA_HWsAUgA]iB?SAIEQc@gCa@sBWsA\"}},{\"duration\":{\"text\":\"1 min\",\"value\":63},\"start_location\":{\"lng\":18.5414209,\"lat\":54.4842094},\"distance\":{\"text\":\"0.7 km\",\"value\":738},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Turn <b>left<\\/b> onto <b>Lotników<\\/b>\",\"end_location\":{\"lng\":18.5382834,\"lat\":54.490489},\"maneuver\":\"turn-left\",\"polyline\":{\"points\":\"impkI{jdpBCMCMMJ[TCB}AfAUN{@n@s@b@s@`@sAl@cA`@A@iA^qA`@}DbAgBb@}@Xs@TqAd@}@`@{@f@\"}},{\"duration\":{\"text\":\"2 mins\",\"value\":98},\"start_location\":{\"lng\":18.5382834,\"lat\":54.490489},\"distance\":{\"text\":\"1.6 km\",\"value\":1643},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Continue onto <b>droga Gdyńska<\\/b>\",\"end_location\":{\"lng\":18.5341166,\"lat\":54.504652},\"polyline\":{\"points\":\"qtqkIgwcpByA|@g@Xe@Xg@Tg@T_@LEBWH[HYH_@H]HoCj@k@JiDr@eAV_AT]J_@J_@J]Ly@Xw@X{Bz@{Bx@c@Nc@R[NYP]Za@^c@h@c@l@]b@CFYXWXGDSRe@Zc@Xq@Xq@T_@HK@UBo@DI@c@AYAk@C]GUEkCo@o@Qa@KyGeBy@Sc@K\"}},{\"duration\":{\"text\":\"1 min\",\"value\":56},\"start_location\":{\"lng\":18.5341166,\"lat\":54.504652},\"distance\":{\"text\":\"0.3 km\",\"value\":288},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Slight <b>right<\\/b> to stay on <b>droga Gdyńska<\\/b>\",\"end_location\":{\"lng\":18.5360438,\"lat\":54.5064819},\"maneuver\":\"turn-slight-right\",\"polyline\":{\"points\":\"amtkIg}bpBOQQKa@QUG[Gk@GMCg@EiBSGCEAEGEEEICIAEIm@@eB?W@a@?]\"}},{\"duration\":{\"text\":\"1 min\",\"value\":63},\"start_location\":{\"lng\":18.5360438,\"lat\":54.5064819},\"distance\":{\"text\":\"0.4 km\",\"value\":386},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Continue straight onto <b>aleja Zwycięstwa<\\/b>\\/<wbr\\/><b>DW468<\\/b>\",\"end_location\":{\"lng\":18.5370266,\"lat\":54.5095591},\"maneuver\":\"straight\",\"polyline\":{\"points\":\"oxtkIgicpB?eA?_@Ge@AA[MWIu@I[EY?oAC[Be@AS?C?e@@_C?aAC[?OK\"}},{\"duration\":{\"text\":\"3 mins\",\"value\":172},\"start_location\":{\"lng\":18.5370266,\"lat\":54.5095591},\"distance\":{\"text\":\"1.2 km\",\"value\":1236},\"travel_mode\":\"DRIVING\",\"html_instructions\":\"Continue straight onto <b>Władysława IV<\\/b><div style=\\\"font-size:0.9em\\\">Destination will be on the left<\\/div>\",\"end_location\":{\"lng\":18.5389784,\"lat\":54.5205912},\"maneuver\":\"straight\",\"polyline\":{\"points\":\"wkukImocpBe@KOC[I_GsAc@I[GWEUCuB[{@K{@KsAOk@Ie@E}@KyAQ{@K_@GwBW_AKa@EYE_AMaAKMCs@IaAKUCMAc@AgA@aA?uA?o@Co@CcBE[CQ?aAD\"}}],\"traffic_speed_entry\":[]}],\"warnings\":[],\"bounds\":{\"southwest\":{\"lng\":18.5194111,\"lat\":54.4778365},\"northeast\":{\"lng\":18.5415563,\"lat\":54.5205912}},\"overview_polyline\":{\"points\":\"kgokIia`pBuCuIWcAAOCaA?a@NNLHRDN?PGZUjAqA`@k@POmCmKaEmPcCeK_@yAaAaC{AeDy@kBu@qBoCoNuD_Sm@{C]iB?SG[aB}ICMMJ_@XsBvAoBrAgCnAeAb@{C`AeHfBqBn@qAd@}@`@uCdBmAr@uB|@mBf@cKtBcEdAoDlA{GdC_Ab@w@l@eAhAaApA}@`Ay@n@uAr@qA^a@Dy@F}@CiAKaDu@eLwCc@KOQs@]q@Oy@KqCYMEKMISKs@@}B@eDIg@s@WqAOiBCyA@eD@}ACOKe@Kk@McH}As@McGw@cFk@iNcBeEe@c@EkB?wC?_BG_CIsAD\"},\"waypoint_order\":[]}],\"geocoded_waypoints\":[{\"types\":[\"street_address\"],\"geocoder_status\":\"OK\",\"place_id\":\"ChIJZ2FIjO6g_UYRxx642XSl6pY\"},{\"types\":[\"street_address\"],\"geocoder_status\":\"OK\",\"place_id\":\"ChIJ8YAk-CSn_UYRb8dapNObl8o\"}],\"status\":\"OK\"}\n");
            pointsHashMap2.put(point,jsonObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("duration").get("value").toString());
            help2++;
            System.out.println(help2);
            if (help2==51){
                break;
            }

        }
        hashMap2.put(1,pointsHashMap2);
        System.out.println(hashMap2.get(1));
        int jjj = 1;
        long lll=0;
        Points farGdansk = new Points();
        for (Points point:wGdansku){
            if (Long.parseLong(hashMap2.get(jjj).get(point))>lll){
                lll = Long.parseLong(hashMap2.get(jjj).get(point));
                farGdansk = point;
                System.out.println("sss");
            }
        }
        System.out.println(lll);
        System.out.println(farGdansk);


        //usuwanie niepotrzebnych punktow
        List<Points> newWSopocie = new ArrayList<>();

        for (Points point:wSopocie){
            System.out.println("1");
            if (!point.equals(firstPoint1)){
                newWSopocie.add(point);
                //System.out.println("dodano point "+point);
            }
            else {
                System.out.println("nie dodano "+point);
            }
        }
        System.out.println(newWSopocie);

        List<Points> newWGdansku = new ArrayList<>();
        for (Points point:wGdansku){
            System.out.println("1");
            if (!point.equals(firstPoint2)){
                newWGdansku.add(point);
                //System.out.println("dodano point "+point);
            }
            else {
                System.out.println("nie dodano "+point);
            }
        }
        System.out.println(newWGdansku);

        String asPointersToGdynia = "https://maps.googleapis.com/maps/api/directions/json?key=tutajKey&origin=";
        asPointersToGdynia = asPointersToGdynia+firstPoint.getCity()+"+"+firstPoint.getStreet().replaceAll(" ","")+"+"+firstPoint.getStreetNumber();
        asPointersToGdynia = asPointersToGdynia+"&destination="+closeSopot.getCity().replaceAll(" ","")+"+"+closeSopot.getStreet().replaceAll(" ","")+"+"+closeSopot.getStreetNumber()+"&waypoints=optimize:true";


        for (Points pointMinus:wGdyni) {
            asPointersToGdynia = asPointersToGdynia+"|"+pointMinus.getCity()+"+"+pointMinus.getStreet().replaceAll(" ","")+"+"+pointMinus.getStreetNumber();
        }
        System.out.println(asPointersToGdynia);

        String asPointersToSopot = "https://maps.googleapis.com/maps/api/directions/json?key=tutajKey&origin=";
        asPointersToSopot = asPointersToSopot+firstPoint1.getCity()+"+"+firstPoint1.getStreet().replaceAll(" ","")+"+"+firstPoint1.getStreetNumber();
        asPointersToSopot = asPointersToSopot+"&destination="+closeGdansk.getCity().replaceAll(" ","")+"+"+closeGdansk.getStreet().replaceAll(" ","")+"+"+closeGdansk.getStreetNumber()+"&waypoints=optimize:true";


        for (Points pointMinus:newWSopocie) {
            asPointersToSopot = asPointersToSopot+"|"+pointMinus.getCity()+"+"+pointMinus.getStreet().replaceAll(" ","")+"+"+pointMinus.getStreetNumber();
        }
        System.out.println(asPointersToSopot);

        String asPointersToGdansk = "https://maps.googleapis.com/maps/api/directions/json?key=tutajKey&origin=";
        asPointersToGdansk = asPointersToGdansk+firstPoint2.getCity()+"+"+firstPoint2.getStreet().replaceAll(" ","")+"+"+firstPoint2.getStreetNumber();
        asPointersToGdansk = asPointersToGdansk+"&destination="+farGdansk.getCity().replaceAll(" ","")+"+"+farGdansk.getStreet().replaceAll(" ","")+"+"+closeSopot.getStreetNumber()+"&waypoints=optimize:true";


        for (Points pointMinus:newWGdansku) {
            asPointersToGdansk = asPointersToGdansk+"|"+pointMinus.getCity()+"+"+pointMinus.getStreet().replaceAll(" ","")+"+"+pointMinus.getStreetNumber();
        }
        System.out.println(asPointersToGdansk);


        //zostało tylko pobrać punkty i walnac z tego trase
        //a no i dodac zapytania i elo

    }
}





