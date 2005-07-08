/*
 * This file is subject to the license found in LICENCE.TXT in the root directory of the project.
 * 
 * #SNAPSHOT#
 */
package fr.jayasoft.ivy;

import java.util.Date;

/**
 * @author Hanin
 *
 */
public class DefaultArtifact extends AbstractArtifact {
    public static Artifact cloneWithAnotherType(Artifact artifact, String newType) {
        return new DefaultArtifact(artifact.getModuleRevisionId(), artifact.getPublicationDate(), artifact.getName(), newType, artifact.getExt());
    }
    
    Date _publicationDate;
    ArtifactRevisionId _arid;
    
    public DefaultArtifact(ModuleRevisionId mrid, Date publicationDate, String name, String type, String ext) {
        if (mrid == null) {
            throw new NullPointerException("null mrid not allowed");
        }
        if (publicationDate == null) {
            throw new NullPointerException("null publication date not allowed");
        }
        if (name == null) {
            throw new NullPointerException("null name not allowed");
        }
        if (type == null) {
            throw new NullPointerException("null type not allowed");
        }
        if (ext == null) {
            throw new NullPointerException("null ext not allowed");
        }
        _publicationDate = publicationDate;
        _arid = ArtifactRevisionId.newInstance(mrid, name, type, ext);
    }

    
    public ModuleRevisionId getModuleRevisionId() {
        return _arid.getModuleRevisionId();
    }
    public String getName() {
        return _arid.getName();
    }
    public Date getPublicationDate() {
        return _publicationDate;
    }
    public String getType() {
        return _arid.getType();
    }
    public String getExt() {
        return _arid.getExt();
    }
    public ArtifactRevisionId getId() {
        return _arid;
    }

    public String[] getConfigurations() {
        return new String[0];
    }
}
