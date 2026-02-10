package com.acromere.recon;

import com.acromere.xenon.Xenon;
import com.acromere.xenon.XenonProgramProduct;
import com.acromere.xenon.resource.Resource;
import com.acromere.xenon.resource.ResourceType;

public class NetworkGraphResourceType extends ResourceType {

	public NetworkGraphResourceType( XenonProgramProduct product ) {
		super( product, "recon" );
		setDefaultCodec( new NetworkGraphCodec( product ) );
	}

	@Override
	public String getKey() {
		return getDefaultCodec().getKey();
	}

	@Override
	public boolean assetOpen( Xenon program, Resource resource ) {
		resource.setModel( new NetworkGraph() );
		return true;
	}

}
