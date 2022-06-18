package de.hsos.swe.abetterstart.bookings.entity;

import de.hsos.swe.abetterstart.common.entity.ImportDTO;

import javax.enterprise.inject.Vetoed;
import javax.ws.rs.FormParam;
import java.time.LocalDateTime;

@Vetoed
public class BookingImportDTO extends ImportDTO<Booking> {

    private long deviceId;
    private LocalDateTime scheduledStart;
    private long intendedDuration;

    public long getDeviceId() {
        return deviceId;
    }

    @FormParam("deviceId")
    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public LocalDateTime getScheduledStart() {
        return scheduledStart;
    }

    @FormParam("scheduledStart")
    public void setScheduledStart(String scheduledStart) {
        this.scheduledStart = LocalDateTime.parse(scheduledStart);
    }

    public long getIntendedDuration() {
        return intendedDuration;
    }

    @FormParam("intendedDuration")
    public void setIntendedDuration(int intendedDuration) {
        this.intendedDuration = intendedDuration;
    }

    public BookingImportDTO() {
    }

    public BookingImportDTO(Booking booking) {
        this.deviceId = booking.getDeviceId();
        this.scheduledStart = booking.getScheduledStart();
        this.intendedDuration = booking.getIntendedDuration();
    }

    @Override
    public String toString() {
        return "BookingImportDTO{" +
                "deviceId=" + deviceId +
                ", scheduledStart=" + scheduledStart +
                ", intendedDuration=" + intendedDuration +
                '}';
    }

    @Override
    public Booking toEntity() {
        Booking booking = new Booking();
        booking.setDeviceId(deviceId);
        booking.setScheduledStart(scheduledStart);
        booking.setIntendedDuration(intendedDuration);
        return booking;
    }
}
