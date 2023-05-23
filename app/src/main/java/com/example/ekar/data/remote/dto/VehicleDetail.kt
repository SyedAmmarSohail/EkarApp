package com.example.ekar.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VehicleDetail(
    @Json(name = "attributes")
    val attributes: Attributes,
    @Json(name = "colors")
    val colors: List<Color>,
    @Json(name = "equipment")
    val equipment: Equipment,
    @Json(name = "input")
    val input: Input,
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "timestamp")
    val timestamp: String,
    @Json(name = "warranties")
    val warranties: List<Warranty>
) {
    @JsonClass(generateAdapter = true)
    data class Attributes(
        @Json(name = "anti_brake_system")
        val antiBrakeSystem: String,
        @Json(name = "cargo_length")
        val cargoLength: String,
        @Json(name = "cargo_volume")
        val cargoVolume: String,
        @Json(name = "category")
        val category: String,
        @Json(name = "city_mileage")
        val cityMileage: String,
        @Json(name = "curb_weight")
        val curbWeight: String,
        @Json(name = "curb_weight_manual")
        val curbWeightManual: String,
        @Json(name = "delivery_charges")
        val deliveryCharges: String,
        @Json(name = "depth")
        val depth: String,
        @Json(name = "doors")
        val doors: String,
        @Json(name = "drivetrain")
        val drivetrain: String,
        @Json(name = "engine")
        val engine: String,
        @Json(name = "engine_cylinders")
        val engineCylinders: String,
        @Json(name = "engine_size")
        val engineSize: String,
        @Json(name = "exterior_color")
        val exteriorColor: List<String>,
        @Json(name = "front_brake_type")
        val frontBrakeType: String,
        @Json(name = "front_headroom")
        val frontHeadroom: String,
        @Json(name = "front_hip_room")
        val frontHipRoom: String,
        @Json(name = "front_legroom")
        val frontLegroom: String,
        @Json(name = "front_shoulder_room")
        val frontShoulderRoom: String,
        @Json(name = "front_spring_type")
        val frontSpringType: String,
        @Json(name = "front_suspension")
        val frontSuspension: String,
        @Json(name = "fuel_capacity")
        val fuelCapacity: String,
        @Json(name = "fuel_type")
        val fuelType: String,
        @Json(name = "gross_vehicle_weight_rating")
        val grossVehicleWeightRating: String,
        @Json(name = "ground_clearance")
        val groundClearance: String,
        @Json(name = "highway_mileage")
        val highwayMileage: String,
        @Json(name = "interior_trim")
        val interiorTrim: List<String>,
        @Json(name = "invoice_price")
        val invoicePrice: String,
        @Json(name = "made_in")
        val madeIn: String,
        @Json(name = "made_in_city")
        val madeInCity: String,
        @Json(name = "make")
        val make: String,
        @Json(name = "manufacturer_suggested_retail_price")
        val manufacturerSuggestedRetailPrice: String,
        @Json(name = "maximum_gvwr")
        val maximumGvwr: String,
        @Json(name = "maximum_payload")
        val maximumPayload: String,
        @Json(name = "maximum_towing")
        val maximumTowing: String,
        @Json(name = "model")
        val model: String,
        @Json(name = "optional_seating")
        val optionalSeating: String,
        @Json(name = "overall_height")
        val overallHeight: String,
        @Json(name = "overall_length")
        val overallLength: String,
        @Json(name = "overall_width")
        val overallWidth: String,
        @Json(name = "passenger_volume")
        val passengerVolume: String,
        @Json(name = "production_seq_number")
        val productionSeqNumber: String,
        @Json(name = "rear_brake_type")
        val rearBrakeType: String,
        @Json(name = "rear_headroom")
        val rearHeadroom: String,
        @Json(name = "rear_hip_room")
        val rearHipRoom: String,
        @Json(name = "rear_legroom")
        val rearLegroom: String,
        @Json(name = "rear_shoulder_room")
        val rearShoulderRoom: String,
        @Json(name = "rear_spring_type")
        val rearSpringType: String,
        @Json(name = "rear_suspension")
        val rearSuspension: String,
        @Json(name = "size")
        val size: String,
        @Json(name = "standard_payload")
        val standardPayload: String,
        @Json(name = "standard_seating")
        val standardSeating: String,
        @Json(name = "standard_towing")
        val standardTowing: String,
        @Json(name = "steering_type")
        val steeringType: String,
        @Json(name = "style")
        val style: String,
        @Json(name = "tires")
        val tires: String,
        @Json(name = "track_front")
        val trackFront: String,
        @Json(name = "track_rear")
        val trackRear: String,
        @Json(name = "transmission")
        val transmission: String,
        @Json(name = "transmission_short")
        val transmissionShort: String,
        @Json(name = "transmission_speeds")
        val transmissionSpeeds: String,
        @Json(name = "transmission_type")
        val transmissionType: String,
        @Json(name = "trim")
        val trim: String,
        @Json(name = "turning_diameter")
        val turningDiameter: String,
        @Json(name = "type")
        val type: String,
        @Json(name = "wheelbase_length")
        val wheelbaseLength: String,
        @Json(name = "width_at_wall")
        val widthAtWall: String,
        @Json(name = "width_at_wheelwell")
        val widthAtWheelwell: String,
        @Json(name = "year")
        val year: String
    )

    @JsonClass(generateAdapter = true)
    data class Color(
        @Json(name = "category")
        val category: String,
        @Json(name = "name")
        val name: String
    )

    @JsonClass(generateAdapter = true)
    data class Equipment(
        @Json(name = "abs_brakes")
        val absBrakes: String,
        @Json(name = "adjustable_foot_pedals")
        val adjustableFootPedals: String,
        @Json(name = "air_conditioning")
        val airConditioning: String,
        @Json(name = "alloy_wheels")
        val alloyWheels: String,
        @Json(name = "am_fm_radio")
        val amFmRadio: String,
        @Json(name = "automatic_headlights")
        val automaticHeadlights: String,
        @Json(name = "automatic_load_leveling")
        val automaticLoadLeveling: String,
        @Json(name = "cargo_area_cover")
        val cargoAreaCover: String,
        @Json(name = "cargo_area_tiedowns")
        val cargoAreaTiedowns: String,
        @Json(name = "cargo_net")
        val cargoNet: String,
        @Json(name = "cassette_player")
        val cassettePlayer: String,
        @Json(name = "cd_changer")
        val cdChanger: String,
        @Json(name = "cd_player")
        val cdPlayer: String,
        @Json(name = "child_safety_door_locks")
        val childSafetyDoorLocks: String,
        @Json(name = "chrome_wheels")
        val chromeWheels: String,
        @Json(name = "cruise_control")
        val cruiseControl: String,
        @Json(name = "daytime_running_lights")
        val daytimeRunningLights: String,
        @Json(name = "deep_tinted_glass")
        val deepTintedGlass: String,
        @Json(name = "driver_airbag")
        val driverAirbag: String,
        @Json(name = "driver_multi_adjustable_power_seat")
        val driverMultiAdjustablePowerSeat: String,
        @Json(name = "dvd_player")
        val dvdPlayer: String,
        @Json(name = "electrochromic_exterior_rearview_mirror")
        val electrochromicExteriorRearviewMirror: String,
        @Json(name = "electrochromic_interior_rearview_mirror")
        val electrochromicInteriorRearviewMirror: String,
        @Json(name = "electronic_brake_assistance")
        val electronicBrakeAssistance: String,
        @Json(name = "electronic_parking_aid")
        val electronicParkingAid: String,
        @Json(name = "first_aid_kit")
        val firstAidKit: String,
        @Json(name = "fog_lights")
        val fogLights: String,
        @Json(name = "front_air_dam")
        val frontAirDam: String,
        @Json(name = "front_cooled_seat")
        val frontCooledSeat: String,
        @Json(name = "front_heated_seat")
        val frontHeatedSeat: String,
        @Json(name = "front_power_lumbar_support")
        val frontPowerLumbarSupport: String,
        @Json(name = "front_power_memory_seat")
        val frontPowerMemorySeat: String,
        @Json(name = "front_side_airbag")
        val frontSideAirbag: String,
        @Json(name = "front_side_airbag_with_head_protection")
        val frontSideAirbagWithHeadProtection: String,
        @Json(name = "front_split_bench_seat")
        val frontSplitBenchSeat: String,
        @Json(name = "full_size_spare_tire")
        val fullSizeSpareTire: String,
        @Json(name = "genuine_wood_trim")
        val genuineWoodTrim: String,
        @Json(name = "glass_rear_window_on_convertible")
        val glassRearWindowOnConvertible: String,
        @Json(name = "heated_exterior_mirror")
        val heatedExteriorMirror: String,
        @Json(name = "heated_steering_wheel")
        val heatedSteeringWheel: String,
        @Json(name = "high_intensity_discharge_headlights")
        val highIntensityDischargeHeadlights: String,
        @Json(name = "interval_wipers")
        val intervalWipers: String,
        @Json(name = "keyless_entry")
        val keylessEntry: String,
        @Json(name = "leather_seat")
        val leatherSeat: String,
        @Json(name = "leather_steering_wheel")
        val leatherSteeringWheel: String,
        @Json(name = "limited_slip_differential")
        val limitedSlipDifferential: String,
        @Json(name = "load_bearing_exterior_rack")
        val loadBearingExteriorRack: String,
        @Json(name = "locking_differential")
        val lockingDifferential: String,
        @Json(name = "locking_pickup_truck_tailgate")
        val lockingPickupTruckTailgate: String,
        @Json(name = "manual_sunroof")
        val manualSunroof: String,
        @Json(name = "navigation_aid")
        val navigationAid: String,
        @Json(name = "passenger_airbag")
        val passengerAirbag: String,
        @Json(name = "passenger_multi_adjustable_power_seat")
        val passengerMultiAdjustablePowerSeat: String,
        @Json(name = "pickup_truck_bed_liner")
        val pickupTruckBedLiner: String,
        @Json(name = "pickup_truck_cargo_box_light")
        val pickupTruckCargoBoxLight: String,
        @Json(name = "power_adjustable_exterior_mirror")
        val powerAdjustableExteriorMirror: String,
        @Json(name = "power_door_locks")
        val powerDoorLocks: String,
        @Json(name = "power_sliding_side_van_door")
        val powerSlidingSideVanDoor: String,
        @Json(name = "power_sunroof")
        val powerSunroof: String,
        @Json(name = "power_trunk_lid")
        val powerTrunkLid: String,
        @Json(name = "power_windows")
        val powerWindows: String,
        @Json(name = "rain_sensing_wipers")
        val rainSensingWipers: String,
        @Json(name = "rear_spoiler")
        val rearSpoiler: String,
        @Json(name = "rear_window_defogger")
        val rearWindowDefogger: String,
        @Json(name = "rear_wiper")
        val rearWiper: String,
        @Json(name = "remote_ignition")
        val remoteIgnition: String,
        @Json(name = "removable_top")
        val removableTop: String,
        @Json(name = "run_flat_tires")
        val runFlatTires: String,
        @Json(name = "running_boards")
        val runningBoards: String,
        @Json(name = "second_row_folding_seat")
        val secondRowFoldingSeat: String,
        @Json(name = "second_row_heated_seat")
        val secondRowHeatedSeat: String,
        @Json(name = "second_row_multi_adjustable_power_seat")
        val secondRowMultiAdjustablePowerSeat: String,
        @Json(name = "second_row_removable_seat")
        val secondRowRemovableSeat: String,
        @Json(name = "second_row_side_airbag")
        val secondRowSideAirbag: String,
        @Json(name = "second_row_side_airbag_with_head_protection")
        val secondRowSideAirbagWithHeadProtection: String,
        @Json(name = "second_row_sound_controls")
        val secondRowSoundControls: String,
        @Json(name = "separate_driver_front_passenger_climate_controls")
        val separateDriverFrontPassengerClimateControls: String,
        @Json(name = "side_head_curtain_airbag")
        val sideHeadCurtainAirbag: String,
        @Json(name = "skid_plate")
        val skidPlate: String,
        @Json(name = "sliding_rear_pickup_truck_window")
        val slidingRearPickupTruckWindow: String,
        @Json(name = "splash_guards")
        val splashGuards: String,
        @Json(name = "steel_wheels")
        val steelWheels: String,
        @Json(name = "steering_wheel_mounted_controls")
        val steeringWheelMountedControls: String,
        @Json(name = "subwoofer")
        val subwoofer: String,
        @Json(name = "tachometer")
        val tachometer: String,
        @Json(name = "telematics_system")
        val telematicsSystem: String,
        @Json(name = "telescopic_steering_column")
        val telescopicSteeringColumn: String,
        @Json(name = "third_row_removable_seat")
        val thirdRowRemovableSeat: String,
        @Json(name = "tilt_steering")
        val tiltSteering: String,
        @Json(name = "tilt_steering_column")
        val tiltSteeringColumn: String,
        @Json(name = "tire_pressure_monitor")
        val tirePressureMonitor: String,
        @Json(name = "tow_hitch_receiver")
        val towHitchReceiver: String,
        @Json(name = "towing_preparation_package")
        val towingPreparationPackage: String,
        @Json(name = "traction_control")
        val tractionControl: String,
        @Json(name = "trip_computer")
        val tripComputer: String,
        @Json(name = "trunk_anti_trap_device")
        val trunkAntiTrapDevice: String,
        @Json(name = "vehicle_anti_theft")
        val vehicleAntiTheft: String,
        @Json(name = "vehicle_stability_control_system")
        val vehicleStabilityControlSystem: String,
        @Json(name = "voice_activated_telephone")
        val voiceActivatedTelephone: String,
        @Json(name = "4wd_awd")
        val wdAwd: String,
        @Json(name = "wind_deflector_for_convertibles")
        val windDeflectorForConvertibles: String
    )

    @JsonClass(generateAdapter = true)
    data class Input(
        @Json(name = "key")
        val key: String,
        @Json(name = "vin")
        val vin: String
    )

    @JsonClass(generateAdapter = true)
    data class Warranty(
        @Json(name = "miles")
        val miles: String,
        @Json(name = "months")
        val months: String,
        @Json(name = "type")
        val type: String
    )
}