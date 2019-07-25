# Recursive delete
#
# Given a directory, delete all the files in the directory and subdirectories that are older than 30 days. If a directory # is empty then delete that directory as well.
#
# logs
# ├── access.log
# ├── app
# |   ├── app1.log
# |   └── app2.log
# ├── apache
# |   ├── localhost.log
# |   └── error.log
# ├── tomcat
# |   ├── localhost_access.log
# |   └── catalina.out
# ├── data
# |   └── threads
# |       ├── td1.txt
# |       └── td2.txt

# You can assume that following calls/apis are provided to you

# ls(path) -> list of items inside the path
# age(file) -> return age in days
# del(file/dir) -> delete the item
# isdir(item) -> returns true if item is a directory

def recursive_delete(path, older_than_days=30):
  content = ls(path)
  
  # Check each item of directory to see if it is a directory or a file
  # If file then if it is old enough to delete 
  for item in content:
    if isdir(item):
      recursive_delete(item, older_than_days)
    else:
      if age(item) > older_than_days:
        del(item)
  
  # Delete directory if it is empty
  if not ls(path):
    del(path)

if __name__ == '__main__':
	recursive_delete('/etc/logs')
