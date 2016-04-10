package at.favre.tools.dconvert.converters.scaling;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Using java natives Graphics2d with best possible renderhints
 */
public class NaiveGraphics2dAlgorithm implements ScaleAlgorithm {
	private Object interpolationValue;

	public NaiveGraphics2dAlgorithm(Object interpolationValue) {
		this.interpolationValue = interpolationValue;
	}

	@Override
	public BufferedImage scale(BufferedImage imageToScale, int dWidth, int dHeight) {

		int imageType = BufferedImage.TYPE_INT_RGB;
		if (imageToScale.getType() != BufferedImage.TYPE_INT_RGB) {
			imageType = BufferedImage.TYPE_INT_ARGB;
		}

		BufferedImage scaledImage = new BufferedImage(dWidth, dHeight, imageType);
		Graphics2D graphics2D = scaledImage.createGraphics();
		graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, interpolationValue);
		graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		graphics2D.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		graphics2D.drawImage(imageToScale, 0, 0, dWidth, dHeight, null);

		graphics2D.dispose();

		return scaledImage;
	}

	@Override
	public String toString() {
		return "NaiveGraphics2d[" + interpolationValue + ']';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		NaiveGraphics2dAlgorithm that = (NaiveGraphics2dAlgorithm) o;

		return interpolationValue != null ? interpolationValue.equals(that.interpolationValue) : that.interpolationValue == null;

	}

	@Override
	public int hashCode() {
		return interpolationValue != null ? interpolationValue.hashCode() : 0;
	}
}
