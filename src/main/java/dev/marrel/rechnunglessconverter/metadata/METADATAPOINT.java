package dev.marrel.rechnunglessconverter.metadata;

import org.mustangproject.ZUGFeRD.XRechnungImporter;
import org.mustangproject.ZUGFeRD.ZUGFeRDImporter;

public enum METADATAPOINT implements MetadataExtractor {
    issueDate (ZUGFeRDImporter::getIssueDate),
    dueDate (ZUGFeRDImporter::getDueDate),
    totalAmount (ZUGFeRDImporter::getAmount),
    buyerName (ZUGFeRDImporter::getBuyerTradePartyName),
    paymentTerms (ZUGFeRDImporter::getPaymentTerms),
    invoiceID (ZUGFeRDImporter::getInvoiceID),
    sellerBIC (ZUGFeRDImporter::getBIC),
    sellerBankName (ZUGFeRDImporter::getBankName),
    sellerIBAN (ZUGFeRDImporter::getIBAN),
    currency (ZUGFeRDImporter::getInvoiceCurrencyCode),
    deliveryPeriod (new DeliveryPeriodExtractor()),
    rechnunglessVersion(new ProgramVersionExtractor()),
    //VALIDITY
    ;

    private final MetadataExtractor extractor;
    METADATAPOINT(MetadataExtractor extractor) {
        this.extractor = extractor;
    }

    @Override
    public String getValue(XRechnungImporter xrechung) {
        return this.extractor.getValue(xrechung);
    }
}