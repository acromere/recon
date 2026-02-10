package com.acromere.recon;

import com.acromere.xenon.Module;
import com.acromere.xenon.ToolRegistration;
import lombok.CustomLog;

@CustomLog
public class Recon extends Module {

	private NetworkGraphResourceType networkGraphAssetType;

	@Override
	public void register() {}

	@Override
	public void startup() {
		registerIcon( "recon", new ReconIcon() );
		registerAssetType( networkGraphAssetType = new NetworkGraphResourceType( this ) );
		registerTool( networkGraphAssetType, new ToolRegistration( this, ReconTool.class ) );

		registerAction( this, "runpause" );
	}

	@Override
	public void shutdown() {
		unregisterAction( "runpause" );

		unregisterTool( networkGraphAssetType, ReconTool.class );
		unregisterAssetType( networkGraphAssetType );
		unregisterIcon( "recon", new ReconIcon() );
	}

	@Override
	public void unregister() {}

}
