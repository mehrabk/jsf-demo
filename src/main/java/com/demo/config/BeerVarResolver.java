package com.demo.config;

import com.sun.faces.util.MessageUtils;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.PropertyNotFoundException;
import javax.el.PropertyNotWritableException;
import java.beans.FeatureDescriptor;
import java.util.Iterator;

/**
 * @author m_kor
 * date 10/21/2023
 */
public class BeerVarResolver extends ELResolver {

    private static final String BEER_PROPERTY_NAME = "beers";
    private static final String[] BEERS = new String[]{"La Chouffe", "Stella Artois"};
    private final Class<?> CONTENT = String[].class;

    @Override
    public Object getValue(ELContext ctx, Object base, Object property) {
        if ((base == null) && property.equals(BEER_PROPERTY_NAME)){
            ctx.setPropertyResolved(true);
            return BEERS;
        }
        return null;
    }

    @Override
    public Class<?> getType(ELContext ctx, Object base, Object property) {
        if (base != null){
            return null;
        }
        if (property == null){
            String message = MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID, "property");
            throw new PropertyNotFoundException(message);
        }
        if (property.equals(BEER_PROPERTY_NAME)){
            ctx.setPropertyResolved(true);
            return CONTENT;
        }

        return null;
    }

    @Override
    public void setValue(ELContext ctx, Object base, Object property, Object value) {
        if (base != null){
            return;
        }
        ctx.setPropertyResolved(false);
        if (property == null){
            String message = MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID, "property");
            throw new PropertyNotFoundException(message);
        }
        if (BEER_PROPERTY_NAME.equals(property)){
            throw new PropertyNotWritableException((String) property);
        }
    }

    @Override
    public boolean isReadOnly(ELContext ctx, Object base, Object property) {
        return true;
    }

    @Override
    public Iterator<FeatureDescriptor> getFeatureDescriptors(ELContext ctx, Object base) {
        return null;
    }

    @Override
    public Class<?> getCommonPropertyType(ELContext ctx, Object base) {
        return String.class;
    }
}