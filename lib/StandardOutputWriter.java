import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StandardOutputWriter {
    private static final int BUFFER_SIZE = 1 << 16;
    private final byte[] buf = new byte[BUFFER_SIZE];
    private final OutputStream out;
    private int ptr = 0;

    public StandardOutputWriter(OutputStream os) {
      this.out = os;
    }

    public StandardOutputWriter(String path) {
      try {
        this.out = new FileOutputStream(path);
      } catch (FileNotFoundException e) {
        throw new RuntimeException("StandardOutputWriter");
      }
    }

    public StandardOutputWriter write(byte b) {
      this.buf[this.ptr++] = b;
      if (this.ptr == BUFFER_SIZE) innerflush();
      return this;
    }

    public StandardOutputWriter write(char c) {
      return write((byte) c);
    }

    public StandardOutputWriter write(char[] s) {
      for (char c : s) {
        this.buf[this.ptr++] = (byte) c;
        if (this.ptr == BUFFER_SIZE) innerflush();
      }
      return this;
    }

    public StandardOutputWriter write(String s) {
      s.chars()
          .forEach(
              c -> {
                this.buf[this.ptr++] = (byte) c;
                if (this.ptr == BUFFER_SIZE) innerflush();
              });
      return this;
    }

    private static int countDigits(int l) {
      if (l >= 1000000000) return 10;
      if (l >= 100000000) return 9;
      if (l >= 10000000) return 8;
      if (l >= 1000000) return 7;
      if (l >= 100000) return 6;
      if (l >= 10000) return 5;
      if (l >= 1000) return 4;
      if (l >= 100) return 3;
      if (l >= 10) return 2;
      return 1;
    }

    public StandardOutputWriter write(int x) {
      if (x == Integer.MIN_VALUE) {
        return write((long) x);
      }
      if (this.ptr + 12 >= BUFFER_SIZE) innerflush();
      if (x < 0) {
        write((byte) '-');
        x = -x;
      }
      int d = countDigits(x);
      for (int i = this.ptr + d - 1; i >= this.ptr; i--) {
        this.buf[i] = (byte) ('0' + x % 10);
        x /= 10;
      }
      this.ptr += d;
      return this;
    }

    private static int countDigits(long l) {
      if (l >= 1000000000000000000L) return 19;
      if (l >= 100000000000000000L) return 18;
      if (l >= 10000000000000000L) return 17;
      if (l >= 1000000000000000L) return 16;
      if (l >= 100000000000000L) return 15;
      if (l >= 10000000000000L) return 14;
      if (l >= 1000000000000L) return 13;
      if (l >= 100000000000L) return 12;
      if (l >= 10000000000L) return 11;
      if (l >= 1000000000L) return 10;
      if (l >= 100000000L) return 9;
      if (l >= 10000000L) return 8;
      if (l >= 1000000L) return 7;
      if (l >= 100000L) return 6;
      if (l >= 10000L) return 5;
      if (l >= 1000L) return 4;
      if (l >= 100L) return 3;
      if (l >= 10L) return 2;
      return 1;
    }

    public StandardOutputWriter write(long x) {
      if (x == Long.MIN_VALUE) {
        return write("" + x);
      }
      if (this.ptr + 21 >= BUFFER_SIZE) innerflush();
      if (x < 0) {
        write((byte) '-');
        x = -x;
      }
      int d = countDigits(x);
      for (int i = this.ptr + d - 1; i >= this.ptr; i--) {
        this.buf[i] = (byte) ('0' + x % 10);
        x /= 10;
      }
      this.ptr += d;
      return this;
    }

    public StandardOutputWriter write(double x, int precision) {
      if (x < 0) {
        write('-');
        x = -x;
      }
      x += Math.pow(10, -precision) / 2;
      write((long) x).write(".");
      x -= (long) x;
      for (int i = 0; i < precision; i++) {
        x *= 10;
        write((char) ('0' + (int) x));
        x -= (int) x;
      }
      return this;
    }

    public StandardOutputWriter writeln(char c) {
      return write(c).writeln();
    }

    public StandardOutputWriter writeln(int x) {
      return write(x).writeln();
    }

    public StandardOutputWriter writeln(long x) {
      return write(x).writeln();
    }

    public StandardOutputWriter writeln(double x, int precision) {
      return write(x, precision).writeln();
    }

    public StandardOutputWriter write(int... xs) {
      boolean first = true;
      for (int x : xs) {
        if (!first) write(' ');
        first = false;
        write(x);
      }
      return this;
    }

    public StandardOutputWriter write(long... xs) {
      boolean first = true;
      for (long x : xs) {
        if (!first) write(' ');
        first = false;
        write(x);
      }
      return this;
    }

    public StandardOutputWriter writeln() {
      return write((byte) '\n');
    }

    public StandardOutputWriter writeln(int... xs) {
      return write(xs).writeln();
    }

    public StandardOutputWriter writeln(long... xs) {
      return write(xs).writeln();
    }

    public StandardOutputWriter writeln(char[] line) {
      return write(line).writeln();
    }

    public StandardOutputWriter writeln(char[]... map) {
      for (char[] line : map) write(line).writeln();
      return this;
    }

    public StandardOutputWriter writeln(String s) {
      return write(s).writeln();
    }

    private void innerflush() {
      try {
        this.out.write(this.buf, 0, this.ptr);
        this.ptr = 0;
      } catch (IOException e) {
        throw new RuntimeException("innerflush");
      }
    }

    public void flush() {
      innerflush();
      try {
        this.out.flush();
      } catch (IOException e) {
        throw new RuntimeException("flush");
      }
    }

    public StandardOutputWriter print(byte b) {
      return write(b);
    }

    public StandardOutputWriter print(char c) {
      return write(c);
    }

    public StandardOutputWriter print(char[] s) {
      return write(s);
    }

    public StandardOutputWriter print(String s) {
      return write(s);
    }

    public StandardOutputWriter print(int x) {
      return write(x);
    }

    public StandardOutputWriter print(long x) {
      return write(x);
    }

    public StandardOutputWriter print(double x, int precision) {
      return write(x, precision);
    }

    public StandardOutputWriter println(char c) {
      return writeln(c);
    }

    public StandardOutputWriter println(int x) {
      return writeln(x);
    }

    public StandardOutputWriter println(long x) {
      return writeln(x);
    }

    public StandardOutputWriter println(double x, int precision) {
      return writeln(x, precision);
    }

    public StandardOutputWriter print(int... xs) {
      return write(xs);
    }

    public StandardOutputWriter print(long... xs) {
      return write(xs);
    }

    public StandardOutputWriter println(int... xs) {
      return writeln(xs);
    }

    public StandardOutputWriter println(long... xs) {
      return writeln(xs);
    }

    public StandardOutputWriter println(char[] line) {
      return writeln(line);
    }

    public StandardOutputWriter println(char[]... map) {
      return writeln(map);
    }

    public StandardOutputWriter println(String s) {
      return writeln(s);
    }

    public StandardOutputWriter println() {
      return writeln();
    }
  }