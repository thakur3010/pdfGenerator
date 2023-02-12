<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21.0cm" margin-top="1cm" margin-left="2cm" margin-right="2cm" margin-bottom="1cm">
                    <!-- Page template goes here -->
                    <fo:region-body />
                    <fo:region-after region-name="xsl-region-after" extent="4cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="A4">
                <!-- Page content goes here -->
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block line-height="20pt">
                        <fo:block font-weight="bold">
                            Terms &amp; Conditions
                        </fo:block>
                        <fo:block space-after="15pt">
                            Payment is due within <xsl:value-of select="invoice/terms" />
                        </fo:block>
                        <fo:block>
                            Increff&#x2028;
                            Account number: 1234567890
                        </fo:block>
                    </fo:block>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body" line-height="20pt">
                    <xsl:apply-templates />
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
    <xsl:template match="invoice">
        <fo:block space-before="35pt">
            <fo:block space-before="120pt" width="17cm" space-after="40pt">
                <fo:table>
                    <fo:table-column column-width="6.5cm"/>
                    <fo:table-column column-width="6.5cm"/>
                    <fo:table-body>
                        <fo:table-row>
                            <fo:table-cell>
                                <fo:block text-align="left">
                                    <fo:inline font-weight="bold">Order ID</fo:inline>&#x2028;
                                    <fo:inline font-weight="bold">Invoice ID</fo:inline>&#x2028;
                                    <fo:inline font-weight="bold">Order Date</fo:inline>&#x2028;
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell>
                                <fo:block text-align="left">
                                    <xsl:value-of select="./orderId"></xsl:value-of>&#x2028;
                                    <xsl:value-of select="./invoiceId"></xsl:value-of>&#x2028;
                                    <xsl:value-of select="./date"></xsl:value-of>&#x2028;
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                    </fo:table-body>
                </fo:table>
            </fo:block>
            <fo:table line-height="30px">
                <fo:table-column column-width="2cm"/>
                <fo:table-column column-width="8cm"/>
                <fo:table-column column-width="3.5cm"/>
                <fo:table-column column-width="3.5cm"/>
                <fo:table-header>
                    <fo:table-row background-color="#f5f5f5" text-align="center" font-weight="bold">
                        <fo:table-cell border="1px solid #b8b6b6">
                            <fo:block>QTY</fo:block>
                        </fo:table-cell>
                        <fo:table-cell border="1px solid #b8b6b6">
                            <fo:block>DESCRIPTION</fo:block>
                        </fo:table-cell>
                        <fo:table-cell border="1px solid #b8b6b6">
                            <fo:block>UNIT PRICE</fo:block>
                        </fo:table-cell>
                        <fo:table-cell border="1px solid #b8b6b6">
                            <fo:block>AMOUNT</fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-header>
                <fo:table-body>
                    <xsl:apply-templates select="lineitems/lineitem"></xsl:apply-templates>
                    <fo:table-row font-weight="bold">
                        <fo:table-cell number-columns-spanned="3" text-align="right" padding-right="3pt" border="1px solid #b8b6b6">
                            <fo:block padding="1mm">Total</fo:block>
                        </fo:table-cell>
                        <fo:table-cell  text-align="right" padding-right="3pt" background-color="#f5f5f5" border="1px solid #b8b6b6" >
                            <fo:block>
                                <xsl:value-of select="total" />
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>
        </fo:block>
    </xsl:template>
    <xsl:template match="lineitem">
        <fo:table-row>
            <fo:table-cell border="1px solid #b8b6b6" text-align="center">
                <fo:block>
                    <xsl:value-of select="quantity"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell border="1px solid #b8b6b6" padding-left="3pt">
                <fo:block>
                    <xsl:value-of select="description"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell border="1px solid #b8b6b6" text-align="right" padding-right="3pt">
                <fo:block>
                    <xsl:value-of select="unitprice"/>
                </fo:block>
            </fo:table-cell>
            <fo:table-cell border="1px solid #b8b6b6" text-align="right" padding-right="3pt">
                <fo:block>
                    <xsl:value-of select="amount"/>
                </fo:block>
            </fo:table-cell>
        </fo:table-row>

    </xsl:template>
</xsl:stylesheet>