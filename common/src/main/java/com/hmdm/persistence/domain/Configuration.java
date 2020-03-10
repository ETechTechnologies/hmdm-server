/*
 *
 * Headwind MDM: Open Source Android MDM Software
 * https://h-mdm.com
 *
 * Copyright (C) 2019 Headwind Solutions LLC (http://h-sms.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hmdm.persistence.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static com.hmdm.persistence.domain.DesktopHeader.NO_HEADER;
import static com.hmdm.persistence.domain.IconSize.SMALL;

@ApiModel(description = "An MDM configuration used on mobile device")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Configuration implements CustomerData, Serializable {

    private static final long serialVersionUID = -7028146375054564719L;
    
    // This group of settings corresponds to common settings
    @ApiModelProperty("A configuration ID")
    private Integer id;
    @ApiModelProperty("A unique name of configuration")
    private String name;
    @ApiModelProperty("A description of configuration")
    private String description;
    @ApiModelProperty("A password for administrator of configuration (MD5 hash)")
    private String password;
    @ApiModelProperty(hidden = true)
    private int type;
    @ApiModelProperty("A list of applications set for configuration")
    private List<Application> applications = new LinkedList<>();
    @ApiModelProperty(hidden = true)
    private int customerId;
    @ApiModelProperty(value = "A flag indicating if application versions update is enabled", hidden = true)
    private final boolean autoUpdate = false;
    @ApiModelProperty("A flag indicating if status bar is locked")
    private boolean blockStatusBar;
    @ApiModelProperty(value = "A system update type. 0-Default, 1-Immediately, 2-Scheduled, 3-Postponed", allowableValues = "0,1,2,3")
    private int systemUpdateType;
    @ApiModelProperty(value = "A start time for system update period formatted as HH:MM. (If system update time is 2)")
    private String systemUpdateFrom;
    @ApiModelProperty(value = "A finish time for system update period formatted as HH:MM. (If system update time is 2)")
    private String systemUpdateTo;

    @ApiModelProperty("A flag indicating if GPS is enabled on device")
    private Boolean gps;
    @ApiModelProperty("A flag indicating if Bluetooth is enabled on device")
    private Boolean bluetooth;
    @ApiModelProperty("A flag indicating if Wi-Fi is enabled on device")
    private Boolean wifi;
    @ApiModelProperty("A flag indicating if Mobile Data is enabled on device")
    private Boolean mobileData;
    @ApiModelProperty("A flag indicating if USB storage is enabled on device")
    private Boolean usbStorage;
    @ApiModelProperty("A type of location tracking")
    private RequestUpdatesType requestUpdates = RequestUpdatesType.DONOTTRACK;
    @ApiModelProperty("Push notification options")
    private String pushOptions;
    @ApiModelProperty("Brightness management flag. null: not managed, false: manual, true: auto")
    private Boolean autoBrightness;
    @ApiModelProperty("Brightness value (if manual), 0-255")
    private Integer brightness;
    @ApiModelProperty("A flag indicating if screen timeout is managed on device")
    private Boolean manageTimeout;
    @ApiModelProperty("Timeout value (in seconds)")
    private Integer timeout;
    @ApiModelProperty("A flag indicating if volume is locked on device")
    private Boolean lockVolume;

    // This group of settings corresponds to MDM settings
    @ApiModelProperty("A package ID for main application")
    private Integer mainAppId;
    @ApiModelProperty("A package ID for event receiving component")
    private String eventReceivingComponent;
    @ApiModelProperty("A flag indicating if MDM is operating in kiosk mode")
    private boolean kioskMode;
    @ApiModelProperty("A package ID for content application")
    private Integer contentAppId;
    @ApiModelProperty("WiFi SSID for provisioning")
    private String wifiSSID;
    @ApiModelProperty("WiFi password for provisioning")
    private String wifiPassword;
    @ApiModelProperty("WiFi security type for provisioning: NONE/WPA/WEP/EAP")
    private String wifiSecurityType;

    // This group of settings corresponds to Design settings
    private boolean useDefaultDesignSettings;
    @ApiModelProperty("A background color to use when running MDM application")
    private String backgroundColor;
    @ApiModelProperty("A text color to use when running MDM application")
    private String textColor;
    @ApiModelProperty("An URL for background image to use when running MDM application")
    private String backgroundImageUrl;
    @ApiModelProperty("A size of the icons to use when running MDM application")
    private IconSize iconSize = SMALL;
    @ApiModelProperty("A type of desktop header to use when running MDM application")
    private DesktopHeader desktopHeader = NO_HEADER;

    // An unique key used for retrieving the QR code for configuration
    @ApiModelProperty(hidden = true)
    private String qrCodeKey;

    @ApiModelProperty("A list of settings for applications set for configuration")
    private List<ApplicationSetting> applicationSettings;

    @ApiModelProperty("A list of files to be used on devices")
    private List<ConfigurationFile> files;

    @ApiModelProperty("The parameters for using applications set for configuration")
    private List<ConfigurationApplicationParameters> applicationUsageParameters;

    @ApiModelProperty(hidden = true)
    private boolean selected;
    @ApiModelProperty(hidden = true)
    private String baseUrl;
    @ApiModelProperty(hidden = true)
    private List<Integer> filesToRemove;

    public Configuration() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Application> getApplications() {
        return this.applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public void setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
    }

    public IconSize getIconSize() {
        return iconSize;
    }

    public void setIconSize(IconSize iconSize) {
        this.iconSize = iconSize;
    }

    public DesktopHeader getDesktopHeader() {
        return desktopHeader;
    }

    public void setDesktopHeader(DesktopHeader desktopHeader) {
        this.desktopHeader = desktopHeader;
    }

    public boolean isUseDefaultDesignSettings() {
        return useDefaultDesignSettings;
    }

    @Override
    public int getCustomerId() {
        return customerId;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Boolean getGps() {
        return gps;
    }

    public void setGps(Boolean gps) {
        this.gps = gps;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getMobileData() {
        return mobileData;
    }

    public void setMobileData(Boolean mobileData) {
        this.mobileData = mobileData;
    }

    public void setUseDefaultDesignSettings(boolean useDefaultDesignSettings) {
        this.useDefaultDesignSettings = useDefaultDesignSettings;
    }

    public Integer getMainAppId() {
        return mainAppId;
    }

    public void setMainAppId(Integer mainAppId) {
        this.mainAppId = mainAppId;
    }

    public Integer getContentAppId() {
        return contentAppId;
    }

    public void setContentAppId(Integer contentAppId) {
        this.contentAppId = contentAppId;
    }

    public String getEventReceivingComponent() {
        return eventReceivingComponent;
    }

    public void setEventReceivingComponent(String eventReceivingComponent) {
        this.eventReceivingComponent = eventReceivingComponent;
    }

    public boolean isKioskMode() {
        return kioskMode;
    }

    public void setKioskMode(boolean kioskMode) {
        this.kioskMode = kioskMode;
    }

    public String getQrCodeKey() {
        return qrCodeKey;
    }

    public void setQrCodeKey(String qrCodeKey) {
        this.qrCodeKey = qrCodeKey;
    }

    public String getWifiSSID() {
        return wifiSSID;
    }

    public void setWifiSSID(String wifiSSID) {
        this.wifiSSID = wifiSSID;
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword;
    }

    public String getWifiSecurityType() {
        return wifiSecurityType;
    }

    public void setWifiSecurityType(String wifiSecurityType) {
        this.wifiSecurityType = wifiSecurityType;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public boolean isAutoUpdate() {
        return autoUpdate;
    }

//    public void setAutoUpdate(boolean autoUpdate) {
//        this.autoUpdate = autoUpdate;
//    }

    public boolean isBlockStatusBar() {
        return blockStatusBar;
    }

    public void setBlockStatusBar(boolean blockStatusBar) {
        this.blockStatusBar = blockStatusBar;
    }

    public int getSystemUpdateType() {
        return systemUpdateType;
    }

    public void setSystemUpdateType(int systemUpdateType) {
        this.systemUpdateType = systemUpdateType;
    }

    public String getSystemUpdateFrom() {
        return systemUpdateFrom;
    }

    public void setSystemUpdateFrom(String systemUpdateFrom) {
        this.systemUpdateFrom = systemUpdateFrom;
    }

    public String getSystemUpdateTo() {
        return systemUpdateTo;
    }

    public void setSystemUpdateTo(String systemUpdateTo) {
        this.systemUpdateTo = systemUpdateTo;
    }

    public List<ApplicationSetting> getApplicationSettings() {
        return applicationSettings;
    }

    public void setApplicationSettings(List<ApplicationSetting> applicationSettings) {
        this.applicationSettings = applicationSettings;
    }

    public List<ConfigurationApplicationParameters> getApplicationUsageParameters() {
        return applicationUsageParameters;
    }

    public void setApplicationUsageParameters(List<ConfigurationApplicationParameters> applicationUsageParameters) {
        this.applicationUsageParameters = applicationUsageParameters;
    }

    public Boolean getUsbStorage() {
        return usbStorage;
    }

    public void setUsbStorage(Boolean usbStorage) {
        this.usbStorage = usbStorage;
    }

    public RequestUpdatesType getRequestUpdates() {
        return requestUpdates;
    }

    public void setRequestUpdates(RequestUpdatesType requestUpdates) {
        this.requestUpdates = requestUpdates;
    }

    public String getPushOptions() {
        return pushOptions;
    }

    public void setPushOptions(String pushOptions) {
        this.pushOptions = pushOptions;
    }

    public Boolean getAutoBrightness() {
        return autoBrightness;
    }

    public void setAutoBrightness(Boolean autoBrightness) {
        this.autoBrightness = autoBrightness;
    }

    public Integer getBrightness() {
        return brightness;
    }

    public void setBrightness(Integer brightness) {
        this.brightness = brightness;
    }

    public Boolean getManageTimeout() {
        return manageTimeout;
    }

    public void setManageTimeout(Boolean manageTimeout) {
        this.manageTimeout = manageTimeout;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Boolean getLockVolume() {
        return lockVolume;
    }

    public void setLockVolume(Boolean lockVolume) {
        this.lockVolume = lockVolume;
    }

    public List<ConfigurationFile> getFiles() {
        return files;
    }

    public void setFiles(List<ConfigurationFile> files) {
        this.files = files;
    }

    public List<Integer> getFilesToRemove() {
        return filesToRemove;
    }

    public void setFilesToRemove(List<Integer> filesToRemove) {
        this.filesToRemove = filesToRemove;
    }

    public Configuration newCopy() {
        Configuration copy = new Configuration();

        copy.setDescription(getDescription());
        copy.setName(getName());
        copy.setApplications(getApplications());
        copy.setApplicationSettings(getApplicationSettings());
        copy.setApplicationUsageParameters(getApplicationUsageParameters());
        copy.setFiles(getFiles());
        copy.setPassword(getPassword());
        copy.setType(getType());
        copy.setCustomerId(getCustomerId());
//        copy.setAutoUpdate(isAutoUpdate());
        copy.setBlockStatusBar(isBlockStatusBar());
        copy.setSystemUpdateType(getSystemUpdateType());
        copy.setSystemUpdateFrom(getSystemUpdateFrom());
        copy.setSystemUpdateTo(getSystemUpdateTo());

        copy.setMainAppId(getMainAppId());
        copy.setContentAppId(getContentAppId());
        copy.setEventReceivingComponent(getEventReceivingComponent());
        copy.setKioskMode(isKioskMode());
        copy.setWifiSSID(getWifiSSID());
        copy.setWifiPassword(getWifiPassword());
        copy.setWifiSecurityType(getWifiSecurityType());

        copy.setGps(getGps());
        copy.setBluetooth(getBluetooth());
        copy.setWifi(getWifi());
        copy.setMobileData(getMobileData());
        copy.setUsbStorage(getUsbStorage());
        copy.setRequestUpdates(getRequestUpdates());
        copy.setPushOptions(getPushOptions());
        copy.setAutoBrightness(getAutoBrightness());
        copy.setBrightness(getBrightness());
        copy.setManageTimeout(getManageTimeout());
        copy.setTimeout(getTimeout());
        copy.setLockVolume(getLockVolume());

        copy.setUseDefaultDesignSettings(isUseDefaultDesignSettings());
        copy.setBackgroundColor(getBackgroundColor());
        copy.setTextColor(getTextColor());
        copy.setBackgroundImageUrl(getBackgroundImageUrl());
        copy.setIconSize(getIconSize());
        copy.setDesktopHeader(getDesktopHeader());

        return copy;
    }
}
