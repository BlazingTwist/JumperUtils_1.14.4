package the_dark_jumper.cannontracer.gui.guielements;

import the_dark_jumper.cannontracer.gui.IJumperGUI;
import the_dark_jumper.cannontracer.gui.utils.FrameColors;
import the_dark_jumper.cannontracer.gui.utils.FrameConfig;
import the_dark_jumper.cannontracer.util.GetterAndSetter;

public class ToggleValueFrame extends DoubleSegmentFrame{
	public final GetterAndSetter<Boolean> source;
	
	public ToggleValueFrame(IJumperGUI parent, FrameConfig config, FrameColors colors, String text, GetterAndSetter<Boolean> source) {
		super(parent, text, Boolean.toString(source.getter.get()), (source.getter.get() ? colors.colorOn : colors.colorOff), config, colors);
		this.source = source;
	}
	
	@Override
	public void setIsClicked(boolean isClicked) {
		if(isClicked) {
			boolean result = !source.getter.get();
			source.setter.accept(result);
			super.valueColor = (result ? colors.colorOn : colors.colorOff);
			super.value = Boolean.toString(result);
		}
	}
}
