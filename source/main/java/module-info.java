import com.acromere.recon.Recon;
import com.acromere.xenon.Module;

module com.acromere.recon {

	// Compile-time only
	requires static lombok;

	// Both compile-time and run-time
	requires com.acromere.xenon;
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	opens com.acromere.recon.bundles;
	exports com.acromere.recon to com.acromere.xenon, com.acromere.zerra;
	provides Module with Recon;

}
