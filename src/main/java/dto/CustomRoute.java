package dto;

import java.util.List;

/**
 * Created by nik on 16.05.16.
 */
public class CustomRoute {
    private Long id;
    private String routeCustomName;
    private List<CustomBus> customBusses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRouteCustomName() {
        return routeCustomName;
    }

    public void setRouteCustomName(String routeCustomName) {
        this.routeCustomName = routeCustomName;
    }

    public List<CustomBus> getCustomBusses() {
        return customBusses;
    }

    public void setCustomBusses(List<CustomBus> customBusses) {
        this.customBusses = customBusses;
    }
}
