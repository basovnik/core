/* 
 * JBoss, Home of Professional Open Source 
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @author tags. All rights reserved. 
 * See the copyright.txt in the distribution for a 
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use, 
 * modify, copy, or redistribute it subject to the terms and conditions 
 * of the GNU Lesser General Public License, v. 2.1. 
 * This program is distributed in the hope that it will be useful, but WITHOUT A 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details. 
 * You should have received a copy of the GNU Lesser General Public License, 
 * v.2.1 along with this distribution; if not, write to the Free Software 
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, 
 * MA  02110-1301, USA.
 */

package org.switchyard.config.model.composite.v1;

import javax.xml.namespace.QName;

import org.switchyard.config.Configuration;
import org.switchyard.config.model.BaseModel;
import org.switchyard.config.model.Descriptor;
import org.switchyard.config.model.composite.CompositeModel;
import org.switchyard.config.model.composite.ExtensionsModel;
import org.switchyard.config.model.switchyard.ThrottlingModel;

/**
 * A version 1 ExtensionsModel.
 */
public class V1ExtensionsModel extends BaseModel implements ExtensionsModel {

    private ThrottlingModel _throttling;

    /**
     * Constructs a new V1ExtensionsModel.
     */
    public V1ExtensionsModel() {
        super(new QName(CompositeModel.DEFAULT_NAMESPACE, V1ExtensionsModel.EXTENSIONS));
    }

    /**
     * Constructs a new V1ExtensionsModel with the specified Configuration and Descriptor.
     * @param config the Configuration
     * @param desc the Descriptor
     */
    public V1ExtensionsModel(Configuration config, Descriptor desc) {
        super(config, desc);
    }

    @Override
    public ThrottlingModel getThrottling() {
        if (_throttling == null) {
            _throttling = (ThrottlingModel) getFirstChildModel(ThrottlingModel.THROTTLING);
        }
        return _throttling;
    }

    @Override
    public ExtensionsModel setThrottling(ThrottlingModel throttling) {
        setChildModel(throttling);
        _throttling = throttling;
        return this;
    }

}
