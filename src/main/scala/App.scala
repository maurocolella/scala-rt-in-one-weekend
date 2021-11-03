import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

object App {
  def phototest(img: BufferedImage): BufferedImage =
  {
    // obtain width and height of image
    val width = img.getWidth
    val height = img.getHeight

    // create new image of the same size
    val out = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)

    // copy pixels with mirroring (mirror vertically)
    for (x <- 0 until width)
      for (y <- 0 until height)
        out.setRGB(x, y, img.getRGB(x, height - y - 1) & 0xffffff)

    // return
    out
  }

  def main(args: Array[String]): Unit =
  {
    // read original image
    val photo1 = ImageIO.read(new File("photo.jpg"))

    // process image
    val photo2 = phototest(photo1)

    // save output image to file "test.jpg"
    ImageIO.write(photo2, "jpg", new File("test.jpg"))
  }
}
