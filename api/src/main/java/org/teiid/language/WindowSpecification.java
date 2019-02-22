/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */
 
 package org.teiid.language;

import java.util.List;

import org.teiid.core.util.EquivalenceUtil;
import org.teiid.core.util.HashCodeUtil;
import org.teiid.language.visitor.LanguageObjectVisitor;

public class WindowSpecification extends BaseLanguageObject {
	
	private List<Expression> partition;
	private OrderBy orderBy;
	private WindowFrame windowFrame;
	
	public WindowSpecification() {
		
	}
	
	public List<Expression> getPartition() {
		return partition;
	}
	
	public void setPartition(List<Expression> grouping) {
		this.partition = grouping;
	}
	
	public OrderBy getOrderBy() {
		return orderBy;
	}
	
	public void setOrderBy(OrderBy orderBy) {
		this.orderBy = orderBy;
	}
	
	public WindowFrame getWindowFrame() {
        return windowFrame;
    }
	
	public void setWindowFrame(WindowFrame windowFrame) {
        this.windowFrame = windowFrame;
    }

	@Override
	public void acceptVisitor(LanguageObjectVisitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public int hashCode() {
		return HashCodeUtil.hashCode(partition.hashCode(), orderBy, windowFrame);
	}
	
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof WindowSpecification)) {
			return false;
		}
		WindowSpecification other = (WindowSpecification)obj;
		return EquivalenceUtil.areEqual(this.partition, other.partition) &&
		EquivalenceUtil.areEqual(this.orderBy, other.orderBy) &&
		EquivalenceUtil.areEqual(this.windowFrame, other.windowFrame);
	}
	
}
