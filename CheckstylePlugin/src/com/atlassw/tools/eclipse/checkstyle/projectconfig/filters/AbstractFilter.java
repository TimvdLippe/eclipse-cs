//============================================================================
//
// Copyright (C) 2002-2005  David Schneider, Lars K�dderitzsch
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
//============================================================================

package com.atlassw.tools.eclipse.checkstyle.projectconfig.filters;

import java.util.List;

/**
 * Base implementation of a filter.
 * 
 * @author Lars K�dderitzsch
 */
public abstract class AbstractFilter implements IFilter
{

    //
    // attributes
    //

    /** name of the filter. */
    private String  mFilterName;

    /** internal name of the filter. */
    private String  mInternalName;

    /** description of the filter. */
    private String  mFilterDescription;

    /** class for the editor of this filter. */
    private Class   mFilterEditor;

    /** flags if the filter is selected. */
    private boolean mSelected;

    /** flags, if the filter is readonly. */
    private boolean mReadonly;

    //
    // methods
    //

    /**
     * {@inheritDoc}
     */
    public void initialize(String name, String internalName, String desc, Class editorClass,
            boolean readonly)
    {

        this.mFilterName = name;
        this.mInternalName = internalName;
        this.mFilterDescription = desc;
        this.mFilterEditor = editorClass;
        this.mReadonly = readonly;
    }

    /**
     * Gets the name of the filter.
     * 
     * @return the filter name
     */
    public final String getName()
    {
        return this.mFilterName;
    }

    /**
     * Gets the internal name of the filter.
     * 
     * @return the internal filter name
     */
    public final String getInternalName()
    {
        return this.mInternalName;
    }

    /**
     * Gets the description of the filter.
     * 
     * @return the description
     */
    public final String getDescription()
    {
        return this.mFilterDescription;
    }

    /**
     * Gets the editor class for the filter.
     * 
     * @return the editor class
     */
    public final Class getEditorClass()
    {
        return this.mFilterEditor;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEditable()
    {

        return this.mFilterEditor != null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEnabled()
    {
        return mSelected;
    }

    /**
     * {@inheritDoc}
     */
    public void setEnabled(boolean selected)
    {
        mSelected = selected;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isReadonly()
    {
        return mReadonly;
    }

    /**
     * {@inheritDoc}
     */
    public List getFilterData()
    {
        //NOOP
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void setFilterData(List filterData)
    {
    //NOOP
    }

    /**
     * {@inheritDoc}
     */
    public String getPresentableFilterData()
    {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Object clone()
    {

        Object o = null;
        try
        {
            o = super.clone();
        }
        catch (CloneNotSupportedException cnse)
        {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
        return o;
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }
        if (this == o)
        {
            return true;
        }
        return this.hashCode() == o.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode()
    {
        //a "nice" prime number, see Java Report, April 2000
        final int prime = 1000003;

        int result = 1;

        result = (result * prime) + (this.mFilterName != null ? this.mFilterName.hashCode() : 0);
        result = (result * prime)
                + (this.mFilterDescription != null ? this.mFilterDescription.hashCode() : 0);
        result = (result * prime)
                + (this.mFilterEditor != null ? this.mFilterEditor.hashCode() : 0);
        result = (result * prime) + Boolean.valueOf(mSelected).hashCode();
        result = (result * prime) + Boolean.valueOf(mReadonly).hashCode();

        return result;
    }

}