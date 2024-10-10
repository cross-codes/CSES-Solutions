import java.io.IOException;
import java.io.OutputStream;

public class OutputWriter {

  private static final int BUFFER_SIZE = 1048576;
  private final byte[] buffer;
  private final OutputStream out;
  private int pos;

  public OutputWriter(OutputStream os) {
    this.out = os;
    this.buffer = new byte[BUFFER_SIZE];
  }

  public OutputWriter append(String s) throws IOException {
    int length = s.length();
    this.ensureCapacity(length);
    for (int i = 0; i < length; i++) this.buffer[this.pos++] = (byte) s.charAt(i);
    return this;
  }

  public OutputWriter append(byte[] bytes) throws IOException {
    if (BUFFER_SIZE - this.pos < bytes.length) {
      this.flush();
      if (bytes.length > BUFFER_SIZE) {
        this.out.write(bytes, 0, bytes.length);
        return this;
      }
    }
    for (byte b : bytes) this.buffer[this.pos++] = b;
    return this;
  }

  public OutputWriter append(byte[] bytes, int from, int to) throws IOException {
    int length = to - from;
    if (BUFFER_SIZE - this.pos < length) {
      this.flush();
      if (length > BUFFER_SIZE) {
        this.out.write(bytes, from, length);
        return this;
      }
    }
    for (int i = from; i < to; i++) this.buffer[this.pos++] = bytes[i];
    return this;
  }

  public OutputWriter append(char c) throws IOException {
    this.ensureCapacity(1);
    this.buffer[this.pos++] = (byte) c;
    return this;
  }

  public OutputWriter append(int i) throws IOException {
    return this.append(Integer.toString(i));
  }

  public OutputWriter append(long l) throws IOException {
    return this.append(Long.toString(l));
  }

  public OutputWriter append(double d) throws IOException {
    return this.append(Double.toString(d));
  }

  public void appendNewLine() throws IOException {
    this.ensureCapacity(1);
    this.buffer[this.pos++] = '\n';
  }

  public void flush() throws IOException {
    this.out.write(this.buffer, 0, this.pos);
    this.pos = 0;
  }

  private void ensureCapacity(int n) throws IOException {
    if (BUFFER_SIZE - this.pos < n) this.flush();
  }
}