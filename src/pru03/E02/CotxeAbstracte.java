/**
 * 
 */
package pru03.E02;

/**
 * @author xavier
 *
 */
public abstract class CotxeAbstracte implements InterfaceCotxe {
	
	protected String marca;
	protected String model;
	protected TipusCanvi tipuscanvi;
	public CotxeAbstracte(String marca, String model, TipusCanvi tipuscanvi) {
		this.marca=marca;
		this.model=model;
		this.tipuscanvi=tipuscanvi;
	}

}
