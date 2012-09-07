/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.jberger.pergen.node;

import org.jberger.pergen.analysis.Analysis;

@SuppressWarnings("nls")
public final class Start extends Node
{
    private PScript _pScript_;
    private EOF _eof_;

    public Start()
    {
        // Empty body
    }

    public Start(
        @SuppressWarnings("hiding") PScript _pScript_,
        @SuppressWarnings("hiding") EOF _eof_)
    {
        setPScript(_pScript_);
        setEOF(_eof_);
    }

    @Override
    public Object clone()
    {
        return new Start(
            cloneNode(this._pScript_),
            cloneNode(this._eof_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseStart(this);
    }

    public PScript getPScript()
    {
        return this._pScript_;
    }

    public void setPScript(PScript node)
    {
        if(this._pScript_ != null)
        {
            this._pScript_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pScript_ = node;
    }

    public EOF getEOF()
    {
        return this._eof_;
    }

    public void setEOF(EOF node)
    {
        if(this._eof_ != null)
        {
            this._eof_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._eof_ = node;
    }

    @Override
    void removeChild(Node child)
    {
        if(this._pScript_ == child)
        {
            this._pScript_ = null;
            return;
        }

        if(this._eof_ == child)
        {
            this._eof_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(Node oldChild, Node newChild)
    {
        if(this._pScript_ == oldChild)
        {
            setPScript((PScript) newChild);
            return;
        }

        if(this._eof_ == oldChild)
        {
            setEOF((EOF) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    public String toString()
    {
        return "" +
            toString(this._pScript_) +
            toString(this._eof_);
    }
}