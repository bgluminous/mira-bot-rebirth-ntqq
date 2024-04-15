package ink.on.central.bot;

import ink.on.central.bot.exception.MiraBotError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池管理类
 * <p>
 * Create Time: 2024-04-12 Last Update:
 *
 * @author BGLuminous
 * @since 1.2.0
 */
public class ThreadPoolManger {
  private static final Logger log = LoggerFactory.getLogger(ThreadPoolManger.class);

  /** 线程池 */
  private ExecutorService executor;

  /** 线程池初始化 */
  private void init() {
    log.info("开始初始化线程池管理器...");
    this.executor = new ThreadPoolExecutor(
      5,
      10,
      60L,
      TimeUnit.SECONDS,
      new LinkedBlockingDeque<>(),
      new MiraThredFactory("MiraBot")
    );
  }

  /** 线程池初始化 */
  public static void prepare() {
    Holder.INSTANCE.init();
  }

  /**
   * 提交任务
   *
   * @param runnable 任务
   */
  public static void push(Runnable runnable) {
    Holder.INSTANCE.executor.execute(runnable);
  }

  /**
   * 强制清理线程池中的任务并重启线程池
   */
  public static void cleanAndReinit() {
    log.warn("开始清理线程池中未结束的任务...");
    List<Runnable> notStartedTasks = Holder.INSTANCE.executor.shutdownNow();
    log.info("已取消等待执行的任务数量: {}", notStartedTasks.size());
    try {
      if (!Holder.INSTANCE.executor.awaitTermination(5, TimeUnit.SECONDS)) {
        log.warn("线程池未能在指定时间内完全终止...");
      }
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
      throw new MiraBotError("线程池等待终止时发生异常!!! 错误信息: %s".formatted(ex.getMessage()));
    }
    log.info("线程池清洗完成!");
    Holder.INSTANCE.init();
  }

  /** 静态内部类 */
  private static class Holder {
    private static final ThreadPoolManger INSTANCE = new ThreadPoolManger();
  }

  /** 线程工厂 */
  @SuppressWarnings("all")
  private static class MiraThredFactory implements ThreadFactory {

    /** thread prefix name */
    public final String namePrefix;
    /** thread group */
    private final ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
    /** current thread number */
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    /** Constructor */
    public MiraThredFactory(String prefix) {
      namePrefix = String.format("%s-Thread-", prefix);
    }

    @Override
    public Thread newThread(Runnable runnable) {
      String threadName = namePrefix + threadNumber.getAndIncrement();
      Thread thread = new Thread(threadGroup, runnable, threadName, 0);
      if (thread.isDaemon()) {
        thread.setDaemon(false);
      }
      if (thread.getPriority() != Thread.NORM_PRIORITY) {
        thread.setPriority(Thread.NORM_PRIORITY);
      }
      return thread;
    }

  }
}
