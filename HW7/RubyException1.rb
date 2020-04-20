class Worker
  def perform
    begin
        retries ||= 0
        puts "try ##{ retries }"
        response = File.read("user.txt").split
        if response.success?
          puts "Ok, we've got items!"
        else
          puts "Uh, server responded with #{response.status}"
        end
    end
  end
end

puts "Hello World"
worker1 = Worker.new
worker1.perform
