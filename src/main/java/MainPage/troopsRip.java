package MainPage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class troopsRip {

    private int personnel_units;
    private int tanks;
    private int armoured_fighting_vehicles;
    private int artillery_systems;
    private int mlrs;
    private int aa_warfare_systems;
    private int planes;
    private int helicopters;
    private int vehicles_fuel_tanks;
    private int warships_cutters;
    private int cruise_missiles;
    private int uav_systems;
    private int special_military_equip;
    private int atgm_srbm_systems;

    public int getPersonnel_units() {
        return personnel_units;
    }

    public void setPersonnel_units(int personnel_units) {
        this.personnel_units = personnel_units;
    }

    public int getTanks() {
        return tanks;
    }

    public void setTanks(int tanks) {
        this.tanks = tanks;
    }

    public int getArmoured_fighting_vehicles() {
        return armoured_fighting_vehicles;
    }

    public void setArmoured_fighting_vehicles(int armoured_fighting_vehicles) {
        this.armoured_fighting_vehicles = armoured_fighting_vehicles;
    }

    public int getArtillery_systems() {
        return artillery_systems;
    }

    public void setArtillery_systems(int artillery_systems) {
        this.artillery_systems = artillery_systems;
    }

    public int getMlrs() {
        return mlrs;
    }

    public void setMlrs(int mlrs) {
        this.mlrs = mlrs;
    }

    public int getAa_warfare_systems() {
        return aa_warfare_systems;
    }

    public void setAa_warfare_systems(int aa_warfare_systems) {
        this.aa_warfare_systems = aa_warfare_systems;
    }

    public int getPlanes() {
        return planes;
    }

    public void setPlanes(int planes) {
        this.planes = planes;
    }

    public int getHelicopters() {
        return helicopters;
    }

    public void setHelicopters(int helicopters) {
        this.helicopters = helicopters;
    }

    public int getVehicles_fuel_tanks() {
        return vehicles_fuel_tanks;
    }

    public void setVehicles_fuel_tanks(int vehicles_fuel_tanks) {
        this.vehicles_fuel_tanks = vehicles_fuel_tanks;
    }

    public int getWarships_cutters() {
        return warships_cutters;
    }

    public void setWarships_cutters(int warships_cutters) {
        this.warships_cutters = warships_cutters;
    }

    public int getCruise_missiles() {
        return cruise_missiles;
    }

    public void setCruise_missiles(int cruise_missiles) {
        this.cruise_missiles = cruise_missiles;
    }

    public int getUav_systems() {
        return uav_systems;
    }

    public void setUav_systems(int uav_systems) {
        this.uav_systems = uav_systems;
    }

    public int getSpecial_military_equip() {
        return special_military_equip;
    }

    public void setSpecial_military_equip(int special_military_equip) {
        this.special_military_equip = special_military_equip;
    }

    public int getAtgm_srbm_systems() {
        return atgm_srbm_systems;
    }

    public void setAtgm_srbm_systems(int atgm_srbm_systems) {
        this.atgm_srbm_systems = atgm_srbm_systems;
    }

    @Override
    public String toString() {
        return "troopsRip{" +
                "personnel_units=" + personnel_units +
                ", tanks=" + tanks +
                ", armoured_fighting_vehicles=" + armoured_fighting_vehicles +
                ", artillery_systems=" + artillery_systems +
                ", mlrs=" + mlrs +
                ", aa_warfare_systems=" + aa_warfare_systems +
                ", planes=" + planes +
                ", helicopters=" + helicopters +
                ", vehicles_fuel_tanks=" + vehicles_fuel_tanks +
                ", warships_cutters=" + warships_cutters +
                ", cruise_missiles=" + cruise_missiles +
                ", uav_systems=" + uav_systems +
                ", special_military_equip=" + special_military_equip +
                ", atgm_srbm_systems=" + atgm_srbm_systems +
                '}';
    }

    public static void TroopsRopParser(String url) throws IOException  {

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setPrettyPrinting();

        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(url).openStream()));

        troopsRip[] troopsRipsPars = gson.fromJson(jsonReader,troopsRip[].class);

        for (troopsRip troops : troopsRipsPars) {
            System.out.println(troops);
        }
    }

    public static void main(String[] args) throws IOException {

        TroopsRopParser("https://russianwarship.rip/api/v2/statistics?offset=50&limit=1");
    }
}
