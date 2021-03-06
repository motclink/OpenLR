/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 2 of the License and the extra
 * conditions for OpenLR. (see openlr-license.txt)
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * <p>
 * Copyright (C) 2009-2019 TomTom International B.V.
 * <p>
 * TomTom (Legal Department)
 * Email: legal@tomtom.com
 * <p>
 * TomTom (Technical contact)
 * Email: openlr@tomtom.com
 * <p>
 * Address: TomTom International B.V., Oosterdoksstraat 114, 1011DK Amsterdam,
 * the Netherlands
 * <p>
 * Copyright (C) 2009-2019 TomTom International B.V.
 * <p>
 * TomTom (Legal Department)
 * Email: legal@tomtom.com
 * <p>
 * TomTom (Technical contact)
 * Email: openlr@tomtom.com
 * <p>
 * Address: TomTom International B.V., Oosterdoksstraat 114, 1011DK Amsterdam,
 * the Netherlands
 */

/**
 *  Copyright (C) 2009-2019 TomTom International B.V.
 *
 *   TomTom (Legal Department)
 *   Email: legal@tomtom.com
 *
 *   TomTom (Technical contact)
 *   Email: openlr@tomtom.com
 *
 *   Address: TomTom International B.V., Oosterdoksstraat 114, 1011DK Amsterdam,
 *   the Netherlands
 */
package eu.datex2.schema._2_0rc2._2_0;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for Validity complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="Validity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="validityStatus" type="{http://datex2.eu/schema/2_0RC2/2_0}ValidityStatusEnum"/>
 *         &lt;element name="validityTimeSpecification" type="{http://datex2.eu/schema/2_0RC2/2_0}OverallPeriod"/>
 *         &lt;element name="validityExtension" type="{http://datex2.eu/schema/2_0RC2/2_0}_ExtensionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Validity", propOrder = {"validityStatus",
        "validityTimeSpecification", "validityExtension"})
public class Validity {

    /** The validity status. */
    @XmlElement(required = true)
    protected ValidityStatusEnum validityStatus;

    /** The validity time specification. */
    @XmlElement(required = true)
    protected OverallPeriod validityTimeSpecification;

    /** The validity extension. */
    protected ExtensionType validityExtension;

    /**
     * Gets the value of the validityStatus property.
     *
     * @return the validity status possible object is {@link ValidityStatusEnum }
     */
    public final ValidityStatusEnum getValidityStatus() {
        return validityStatus;
    }

    /**
     * Sets the value of the validityStatus property.
     *
     * @param value
     *            allowed object is {@link ValidityStatusEnum }
     *
     */
    public final void setValidityStatus(final ValidityStatusEnum value) {
        this.validityStatus = value;
    }

    /**
     * Gets the value of the validityTimeSpecification property.
     *
     * @return the validity time specification possible object is
     *         {@link OverallPeriod }
     */
    public final OverallPeriod getValidityTimeSpecification() {
        return validityTimeSpecification;
    }

    /**
     * Sets the value of the validityTimeSpecification property.
     *
     * @param value
     *            allowed object is {@link OverallPeriod }
     *
     */
    public final void setValidityTimeSpecification(final OverallPeriod value) {
        this.validityTimeSpecification = value;
    }

    /**
     * Gets the value of the validityExtension property.
     *
     * @return the validity extension possible object is {@link ExtensionType }
     */
    public final ExtensionType getValidityExtension() {
        return validityExtension;
    }

    /**
     * Sets the value of the validityExtension property.
     *
     * @param value
     *            allowed object is {@link ExtensionType }
     *
     */
    public final void setValidityExtension(final ExtensionType value) {
        this.validityExtension = value;
    }

    /**
     * To string.
     *
     * @param toStringBuilder
     *            the to string builder
     */
    public final void toString(final ToStringBuilder toStringBuilder) {
        ValidityStatusEnum theValidityStatus;
        theValidityStatus = this.getValidityStatus();
        toStringBuilder.append("validityStatus", theValidityStatus);
        OverallPeriod theValidityTimeSpecification;
        theValidityTimeSpecification = this.getValidityTimeSpecification();
        toStringBuilder.append("validityTimeSpecification",
                theValidityTimeSpecification);
        ExtensionType theValidityExtension;
        theValidityExtension = this.getValidityExtension();
        toStringBuilder.append("validityExtension", theValidityExtension);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        final ToStringBuilder toStringBuilder = new ToStringBuilder(this);
        toString(toStringBuilder);
        return toStringBuilder.toString();
    }

    /**
     * Equals.
     *
     * @param object
     *            the object
     * @param equalsBuilder
     *            the equals builder
     */
    public final void equals(final Object object,
                             final EqualsBuilder equalsBuilder) {
        if (!(object instanceof Validity)) {
            equalsBuilder.appendSuper(false);
            return;
        }
        if (this == object) {
            return;
        }
        final Validity that = ((Validity) object);
        equalsBuilder
                .append(this.getValidityStatus(), that.getValidityStatus());
        equalsBuilder.append(this.getValidityTimeSpecification(),
                that.getValidityTimeSpecification());
        equalsBuilder.append(this.getValidityExtension(),
                that.getValidityExtension());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(final Object object) {
        if (!(object instanceof Validity)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final EqualsBuilder equalsBuilder = new EqualsBuilder();
        equals(object, equalsBuilder);
        return equalsBuilder.isEquals();
    }

    /**
     * Hash code.
     *
     * @param hashCodeBuilder
     *            the hash code builder
     */
    public final void hashCode(final HashCodeBuilder hashCodeBuilder) {
        hashCodeBuilder.append(this.getValidityStatus());
        hashCodeBuilder.append(this.getValidityTimeSpecification());
        hashCodeBuilder.append(this.getValidityExtension());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        hashCode(hashCodeBuilder);
        return hashCodeBuilder.toHashCode();
    }

}
