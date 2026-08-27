package com.acromere.recon;

import com.acromere.xenon.Module;
import com.acromere.xenon.ToolRegistration;
import lombok.CustomLog;

@CustomLog
public class Recon extends Module {

	private NetworkGraphResourceType networkGraphResourceType;

	@Override
	public void register() {}

	@Override
	public void startup() {
		registerIcon( "recon", new ReconIcon() );
		registerResourceType( networkGraphResourceType = new NetworkGraphResourceType( this ) );
		registerTool( networkGraphResourceType, new ToolRegistration( this, ReconTool.class ) );

		registerAction( this, "runpause" );
	}

	@Override
	public void shutdown() {
		unregisterAction( "runpause" );

		unregisterTool( networkGraphResourceType, ReconTool.class );
		unregisterResourceType( networkGraphResourceType );
		unregisterIcon( "recon", new ReconIcon() );
	}

	@Override
	public void unregister() {}

}
