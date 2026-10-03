module.exports = {
  apps: [
    {
      name: "domin-api",
      script: "demo-0.0.1-SNAPSHOT.jar",
      cwd: "/mnt/Storage2/Storage/API",
      interpreter: "java",
      interpreter_args: "-jar",
      autorestart: true,
      max_restarts: 10,
      restart_delay: 5000,
      max_memory_restart: "512M",
      out_file: "/mnt/Storage2/Storage/API/logs/out.log",
      error_file: "/mnt/Storage2/Storage/API/logs/error.log",
      log_date_format: "YYYY-MM-DD HH:mm:ss"
    }
  ]
};
