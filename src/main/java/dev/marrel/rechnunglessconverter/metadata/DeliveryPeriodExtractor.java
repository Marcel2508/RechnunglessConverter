package dev.marrel.rechnunglessconverter.metadata;

import org.mustangproject.ZUGFeRD.XRechnungImporter;

import java.text.SimpleDateFormat;

public class DeliveryPeriodExtractor implements MetadataExtractor{
    @Override
    public String getValue(XRechnungImporter xrechung) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
        String result = sdf.format(xrechung.getDetailedDeliveryPeriodFrom());
        if(xrechung.getDetailedDeliveryPeriodTo() != null)
            result += " - " + sdf.format(xrechung.getDetailedDeliveryPeriodTo());
        return result;
    }
}